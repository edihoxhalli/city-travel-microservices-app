package com.edi.citytravel.travelcalculationservice.web;

import com.edi.citytravel.travelcalculationservice.domain.model.TravelRecord;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="travel-records-service")
@RibbonClient(name="travel-records-service")
public interface TravelRecordsFeignClient {

    @GetMapping("/travel-record/find-by-departure-city/{city}")
    List<TravelRecord> findByDepartureCity(@PathVariable("city") String city);

}
