package com.vendor.api.airport.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.vendor.api.airport.entity.AirportEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface AirportService {

public Flux<JsonNode> fetchAirports(Integer count);
public Mono<AirportEntity> getAirportById(Long airportId);
Mono<Void> insertAirportById(AirportEntity airportEntity);

default void defaultMethod(){
}

}
