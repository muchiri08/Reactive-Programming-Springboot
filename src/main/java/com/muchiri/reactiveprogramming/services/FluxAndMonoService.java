package com.muchiri.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class FluxAndMonoService {

    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana")).log();
    }

    public Flux<String> fruitsFluxMap() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana")).map(String::toUpperCase);
    }

    public Flux<String> fruitsFluxFilter(int num) {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .filter(fruit -> fruit.length() > num);
    }

    public Flux<String> fruitsFluxFlatMap() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .flatMap(fruit -> Flux.just(fruit.split("")))
                .log();
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

        fluxAndMonoService.fruitsFluxMap().subscribe(fruit -> {
            System.out.println("Map-> Flux: " + fruit);
        });
    }
}
