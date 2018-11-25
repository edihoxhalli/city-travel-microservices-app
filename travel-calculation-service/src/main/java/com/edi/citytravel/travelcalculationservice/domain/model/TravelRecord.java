package com.edi.citytravel.travelcalculationservice.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TravelRecord {

    private Long id;

    private String fromCity;

    private String toCity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime departure;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime arrival;

}
