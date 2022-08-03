package com.sistemabancario.demand.Service;

import com.sistemabancario.demand.domain.Demand;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IDemandService {

    Flux<Demand> findAll();
    Mono<Demand> findById(String id);
    Mono<Demand> save(Demand demand);
    Mono<Demand> update(Demand demand);
    Mono<Void> deleteById(String id);


}
