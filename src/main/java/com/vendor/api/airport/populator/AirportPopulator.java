package com.vendor.api.airport.populator;

import com.vendor.api.airport.entity.AirportEntity;
import com.vendor.api.airport.model.AirportDTO;
import org.springframework.stereotype.Service;

@Service
public class AirportPopulator {

    public AirportEntity populateAirportEntity(AirportDTO airportDTO){
        AirportEntity airport = new AirportEntity();

        airport.setAirportId(airportDTO.getAirportId());
        airport.setName(airportDTO.getName());
        airport.setCity(airportDTO.getCity());
        airport.setCountry(airportDTO.getCountry());
        airport.setIataFaa(airportDTO.getIataFaa());
        airport.setIcao(airportDTO.getIcao());
        airport.setLatitude(airportDTO.getLatitude());
        airport.setLongitude(airportDTO.getLongitude());
        airport.setAltitude(airportDTO.getAltitude());
        airport.setTimezone(airportDTO.getTimezone());
        airport.setDst(airportDTO.getDst());
        airport.setTz(airportDTO.getTz());

        return airport;
    }



}
