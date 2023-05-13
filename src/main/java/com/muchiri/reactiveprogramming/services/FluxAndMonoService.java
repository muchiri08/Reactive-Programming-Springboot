package com.muchiri.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoService {

    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana")).log();
    }

    public Mono<String> fruitMono() {
        return Mono.just("Mango");
    }

    public static void main(String[] args) {
        FluxAndMonoService fluxAndMonoService = new FluxAndMonoService();

        fluxAndMonoService.fruitsFlux().subscribe(fruit -> {
            System.out.println("Flux-> Fruit: " + fruit);
        });

        fluxAndMonoService.fruitMono().subscribe(fruit -> {
            System.out.println("Mono-> Fruit: " + fruit);
        });
    }
}
