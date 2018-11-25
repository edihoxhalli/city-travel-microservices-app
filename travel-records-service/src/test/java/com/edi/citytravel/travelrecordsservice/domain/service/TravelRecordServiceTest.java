package com.edi.citytravel.travelrecordsservice.domain.service;

import com.edi.citytravel.travelrecordsservice.domain.model.TravelRecord;
import com.edi.citytravel.travelrecordsservice.domain.repository.TravelRecordRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class TravelRecordServiceTest {

    @Autowired
    private TravelRecordService service;

    @Autowired
    private TravelRecordRepository repository;


    @Test
    @DatabaseSetup("/travel_records.xml")
    public void findShortestPathInConnectionsTest(){
        List<String> travelRecords = service.findShortestPath("milan", "tirana");
        travelRecords.forEach(System.out::println);
        Assert.assertEquals(Arrays.asList("milan", "lasvegas","madrid", "tirana"), travelRecords);
    }

    @Test
    @DatabaseSetup("/travel_records.xml")
    public void findShortestPathInTimeTest(){
        List<String> travelRecords = service.findShortestPathTime("milan", "tirana");
        travelRecords.forEach(System.out::println);
        Assert.assertEquals(Arrays.asList("milan", "lasvegas","madrid", "bolognia", "durres", "tirana"), travelRecords);
    }

}
