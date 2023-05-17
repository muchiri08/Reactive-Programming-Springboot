package com.muchiri.reactiveprogramming.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoServiceTest {

    FluxAndMonoService fluxAndMonoService = new FluxAndMonoService();

    @Test
    void fruitsFlux() {
        var fruitsFlux = fluxAndMonoService.fruitsFlux();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Orange", "Banana")
                .verifyComplete();
    }

    @Test
    void fruitMono() {
        var fruitMono = fluxAndMonoService.fruitMono();
        StepVerifier.create(fruitMono)
                .expectNext("Mango")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        var fruitFluxMap = fluxAndMonoService.fruitsFluxMap();
        StepVerifier.create(fruitFluxMap)
                .expectNext("MANGO", "ORANGE", "BANANA")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilter() {
        var fruitFluxFilter = fluxAndMonoService.fruitsFluxFilter(5);
        StepVerifier.create(fruitFluxFilter)
                .expectNext("Orange", "Banana")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMap() {
        var fruitFluxFilter = fluxAndMonoService.fruitsFluxFlatMap();
        StepVerifier.create(fruitFluxFilter)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMapAsync() {
        var fruitFluxFilter = fluxAndMonoService.fruitsFluxFlatMapAsync();
        StepVerifier.create(fruitFluxFilter)
                .expectNextCount(17)
                .verifyComplete();
    }
}