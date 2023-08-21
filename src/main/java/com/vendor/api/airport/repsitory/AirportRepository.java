package com.vendor.api.airport.repsitory;

import com.vendor.api.airport.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<AirportEntity,Long> {
}
