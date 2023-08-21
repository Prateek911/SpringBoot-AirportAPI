package com.vendor.api.airport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class AirportEntity {

    @Id
    @Column(name = "airport_id")
    private Long airportId;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "iata_faa")
    private String iataFaa;

    @Column(name = "icao")
    private String icao;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "altitude")
    private Double altitude;

    @Column(name = "timezone")
    private Integer timezone;

    @Column(name = "dst")
    private String dst;

    @Column(name = "tz")
    private String tz;

}
