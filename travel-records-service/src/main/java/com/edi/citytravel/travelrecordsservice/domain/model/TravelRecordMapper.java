package com.edi.citytravel.travelrecordsservice.domain.model;

import com.edi.citytravel.travelrecordsservice.domain.entity.TravelRecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Mapper
public interface TravelRecordMapper {

    TravelRecordMapper INSTANCE = Mappers.getMapper( TravelRecordMapper.class );

    TravelRecord toModel(TravelRecordEntity travelRecordEntity);

    TravelRecordEntity toEntity(TravelRecord travelRecord);

    default LocalDateTime dateToLocalDateTime(Date entityDate) {
        if(entityDate != null){
            return entityDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
        } else {
            return LocalDateTime.now();
        }
    }

    default Date localDateTimeToDate(LocalDateTime modelDate) {
        if(modelDate != null){
            return Date.from(modelDate.atZone(ZoneId.systemDefault())
                    .toInstant());
        } else {
            return new Date();
        }
    }

}
