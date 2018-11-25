package com.edi.citytravel.travelcalculationservice.web;

import com.edi.citytravel.travelcalculationservice.domain.service.TravelCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/travel-calc")
public class TravelCalculationController {

    @Autowired
    private TravelCalculationService service;

    @GetMapping("/path-in-connections/from/{from}/to/{to}")
    public List<String> findShortestPathInConnections(@PathVariable String from, @PathVariable String to){
        return service.findShortestPath(from, to);
    }

    @GetMapping("/path-in-time/from/{from}/to/{to}")
    public List<String> findShortestPathInTime(@PathVariable String from, @PathVariable String to){
        return service.findShortestPathTime(from, to);
    }

}
