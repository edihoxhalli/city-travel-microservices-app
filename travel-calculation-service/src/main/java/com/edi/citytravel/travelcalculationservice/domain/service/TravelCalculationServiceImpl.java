package com.edi.citytravel.travelcalculationservice.domain.service;

import com.edi.citytravel.travelcalculationservice.domain.model.TravelRecord;
import com.edi.citytravel.travelcalculationservice.web.TravelRecordsFeignClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TravelCalculationServiceImpl implements TravelCalculationService {

    @Autowired
    private TravelRecordsFeignClient client;

    public List<String> findShortestPath(String from, String to){
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        boolean found = false;

        Map<String, String> cityToPreviousMap = new HashMap<>();

        String currentCity;
        queue.add(from);

        while (!queue.isEmpty() && !found) {
            currentCity = queue.poll();
            if(currentCity.equals(to)) {
                found = true;
            }
            visited.add(currentCity);

            List<String> nextCities = client.findByDepartureCity(currentCity)
                    .stream().map(travelRecord -> travelRecord.getToCity()).collect(Collectors.toList());
            for(String nextCity : nextCities) {
                if(!visited.contains(nextCity)) {
                    if(!cityToPreviousMap.containsKey(nextCity)){
                        cityToPreviousMap.put(nextCity, currentCity);
                    }
                    queue.add(nextCity);
                }
            }
        }
        List<String> shortestPath = new ArrayList<>();
        if(found) {
            String previousCity = to;
            while(previousCity!=null) {
                shortestPath.add(previousCity);
                previousCity = cityToPreviousMap.get(previousCity);
            }
            Collections.reverse(shortestPath);
        }

        return shortestPath;
    }

    public List<String> findShortestPathTime(String from, String to){

        Map<String, CityData> cityToDurationMap = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        String currentCity;

        queue.add(from);
        visited.add(from);
        cityToDurationMap.put(from, new CityData(null, Duration.ZERO));

        while(!queue.isEmpty()){
            currentCity = queue.poll();

            List<TravelRecord> nextCities = client.findByDepartureCity(currentCity);
            for(TravelRecord nextCity : nextCities) {
                String toCityName = nextCity.getToCity();
                if(!visited.contains(toCityName)) {
                    queue.add(toCityName);
                }
                updateDurationMap(cityToDurationMap, nextCity);
            }
            visited.add(currentCity);
        }

        List<String> shortestPath = new ArrayList<>();
        if(cityToDurationMap.containsKey(to)) {
            String previousCity = to;
            while(previousCity!=null) {
                shortestPath.add(previousCity);
                previousCity = cityToDurationMap.get(previousCity).getPreviousCity();
            }
            Collections.reverse(shortestPath);
        }

        return shortestPath;
    }

    private void updateDurationMap(Map<String, CityData> cityToDurationMap, TravelRecord nextRecord){
        Duration previousCityDuration = cityToDurationMap.get(nextRecord.getFromCity()).getDurationFromStart();
        Duration currentToNextCityDuration = Duration.between(nextRecord.getDeparture(), nextRecord.getArrival());

        if(cityToDurationMap.containsKey(nextRecord.getToCity())){
            Duration currentDuration = cityToDurationMap.get(nextRecord.getToCity()).getDurationFromStart();
            Duration possibleShorterDuration = previousCityDuration.plus(currentToNextCityDuration);

            if(possibleShorterDuration.compareTo(currentDuration) < 0){
                cityToDurationMap.put(nextRecord.getToCity(), new CityData(nextRecord.getFromCity(), possibleShorterDuration));
            }
        } else {
            cityToDurationMap.put(nextRecord.getToCity(), new CityData(nextRecord.getFromCity(), previousCityDuration.plus(currentToNextCityDuration)));
        }
    }

    @AllArgsConstructor
    @Data
    static class CityData {
        private String previousCity;
        private Duration durationFromStart;
    }
}
