package com.vendor.api.airport.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.vendor.api.airport.entity.AirportEntity;
import com.vendor.api.airport.model.AirportDTO;
import com.vendor.api.airport.populator.AirportPopulator;
import com.vendor.api.airport.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;
    private final AirportPopulator airportPopulator;


    public AirportController(AirportService airportService, AirportPopulator airportPopulator) {

        this.airportService = airportService;
        this.airportPopulator = airportPopulator;
    }

    @GetMapping("/airports/{count}")
    public Flux<JsonNode> getAirports(@PathVariable Integer count){

        return airportService.fetchAirports(count);

    }

    @GetMapping("/airport/{id}")
    public Mono<AirportEntity> getAirport(@PathVariable Long id){

        return airportService.getAirportById(id);

    }

    @PostMapping("/insertAirport")
    public Mono<ResponseEntity<String>> insertAirport(@RequestBody AirportDTO airportDTO){

         Long id = airportDTO.getAirportId();

         Mono<AirportEntity> monoAirport = airportService.getAirportById(id);

        Mono<ResponseEntity<String>> successResponseMono = monoAirport.flatMap(airport -> {
            AirportEntity airportEntity = airportPopulator.populateAirportEntity(airportDTO);

            return airportService.insertAirportById(airportEntity)
                    .map(result -> ResponseEntity.status(HttpStatus.OK).body("Record inserted into Database for id: " + id));
        });


        Mono<ResponseEntity<String>> errorResponseMono = Mono.just(
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error occurred while inserting for id: " + id)
        );


        return successResponseMono.switchIfEmpty(errorResponseMono);

    }

    @GetMapping("/getTest")
    public String getTest(){

        return "Hello World!!";

    }
}
