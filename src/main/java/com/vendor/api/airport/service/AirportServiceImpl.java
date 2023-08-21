package com.vendor.api.airport.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.vendor.api.airport.entity.AirportEntity;
import com.vendor.api.airport.repsitory.AirportRepository;
import com.vendor.api.airport.utility.Constants;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AirportServiceImpl implements AirportService{



    private final WebClient webClient;
    private final AirportRepository airportRepository;

    public AirportServiceImpl(WebClient.Builder webClientBuilder, AirportRepository airportRepository) {
        this.webClient = webClientBuilder.baseUrl(Constants.API_BASE_URL).build();
        this.airportRepository = airportRepository;
    }

    @Override
    public Flux<JsonNode> fetchAirports(Integer count) {
        return webClient.get()
                .uri(Constants.API_ENDPOINT)
                .retrieve()
                .bodyToFlux(JsonNode.class)
                .take(count);
    }

    @Override
    public Mono<AirportEntity> getAirportById(Long airportId) {
        return webClient.get()
                .uri(Constants.API_ENDPOINT)
                .retrieve()
                .bodyToFlux(AirportEntity.class)
                .filter(airport->airport.getAirportId().equals(airportId))
                .next();

    }

    @Override
    public Mono<Void> insertAirportById(AirportEntity airportEntity) {

        return Mono.fromRunnable(() -> {
            airportRepository.save(airportEntity);
        });

    }
}
