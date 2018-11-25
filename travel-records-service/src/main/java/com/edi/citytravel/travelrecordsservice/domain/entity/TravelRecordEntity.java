package com.edi.citytravel.travelrecordsservice.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "travel_record")
public class TravelRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "from_city")
    private String fromCity;

    @Column(name = "to_city")
    private String toCity;

    private Date departure;

    private Date arrival;


}
