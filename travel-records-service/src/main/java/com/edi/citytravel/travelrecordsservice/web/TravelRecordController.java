package com.edi.citytravel.travelrecordsservice.web;

import com.edi.citytravel.travelrecordsservice.domain.model.TravelRecord;
import com.edi.citytravel.travelrecordsservice.domain.service.TravelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel-record")
@Validated
public class TravelRecordController {

    @Autowired
    private TravelRecordService travelRecordService;

    @GetMapping("/all")
    public List<TravelRecord> getAllTravelRecords() {
        return travelRecordService.getAllTravelRecords();
    }

    @GetMapping("/{id}")
    public TravelRecord getTravelRecord(@PathVariable Long id){
        return travelRecordService.getTravelRecord(id);
    }

    @PostMapping
    public TravelRecord createTravelRecord(@RequestBody TravelRecord travelRecord){
        return travelRecordService.createTravelRecord(travelRecord);
    }

    @PostMapping("/bulk")
    public List<TravelRecord> createTravelRecords(@RequestBody List<TravelRecord> travelRecords){
        return travelRecordService.createTravelRecords(travelRecords);
    }

    @PutMapping
    public TravelRecord updateTravelRecord(@RequestBody TravelRecord travelRecord){
        return travelRecordService.updateTravelRecord(travelRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteTravelRecord(@PathVariable Long id){
        travelRecordService.deleteTravelRecord(id);
    }

    @GetMapping("/find-by-departure-city/{city}")
    public List<TravelRecord> findByDepartureCity(@PathVariable String city){
        return travelRecordService.findTravelRecordsByFromCity(city);
    }


}
