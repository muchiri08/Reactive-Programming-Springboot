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
                .expectComplete();
    }

    @Test
    void fruitMono() {
        var fruitMono = fluxAndMonoService.fruitMono();
        StepVerifier.create(fruitMono)
                .expectNext("Mango")
                .expectComplete();
    }
}