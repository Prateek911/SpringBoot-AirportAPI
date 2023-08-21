package com.vendor.api.airport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportDTO {
    private Long airportId;
    private String name;
    private String city;
    private String country;
    private String iataFaa;
    private String icao;
    private Double latitude;
    private Double longitude;
    private Double altitude;
    private Integer timezone;
    private String dst;
    private String tz;

}

