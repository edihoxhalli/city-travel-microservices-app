package com.edi.citytravel.travelcalculationservice.domain.service;

import java.util.List;

public interface TravelCalculationService {

    List<String> findShortestPath(String from, String to);

    List<String> findShortestPathTime(String from, String to);

}
