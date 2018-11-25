package com.edi.citytravel.travelrecordsservice.domain.repository;

import com.edi.citytravel.travelrecordsservice.domain.entity.TravelRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelRecordRepository extends JpaRepository<TravelRecordEntity, Long> {

    List<TravelRecordEntity> findByFromCity(String fromCity);
}
