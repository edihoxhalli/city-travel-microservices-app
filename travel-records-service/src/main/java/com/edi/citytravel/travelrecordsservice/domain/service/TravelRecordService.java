package com.edi.citytravel.travelrecordsservice.domain.service;

import com.edi.citytravel.travelrecordsservice.domain.model.TravelRecord;

import java.time.Duration;
import java.util.List;

public interface TravelRecordService {

    List<TravelRecord> getAllTravelRecords();

    TravelRecord getTravelRecord(Long id);

    TravelRecord createTravelRecord(TravelRecord travelRecord);

    List<TravelRecord> createTravelRecords(List<TravelRecord> travelRecord);

    TravelRecord updateTravelRecord(TravelRecord travelRecord);

    void  deleteTravelRecord(Long id);

    List<TravelRecord> findTravelRecordsByFromCity(String fromCity);

    List<String> findShortestPath(String from, String to);

    List<String> findShortestPathTime(String from, String to);
}
