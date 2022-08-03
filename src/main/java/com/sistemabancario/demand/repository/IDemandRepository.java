package com.sistemabancario.demand.repository;

import com.sistemabancario.demand.domain.Demand;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDemandRepository extends ReactiveCrudRepository<Demand,String> {
}
