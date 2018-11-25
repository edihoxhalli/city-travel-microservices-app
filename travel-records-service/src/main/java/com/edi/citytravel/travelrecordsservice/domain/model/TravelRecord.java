package com.edi.citytravel.travelrecordsservice.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TravelRecord {

    private Long id;

    @NonNull
    private String fromCity;

    @NonNull
    private String toCity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @NonNull
    private LocalDateTime departure;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @NonNull
    private LocalDateTime arrival;

}
