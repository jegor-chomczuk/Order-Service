package com.bookapp.orderservice.sampleDataPackage;

import com.bookapp.orderservice.OrderRepository;
import com.bookapp.orderservice.dao.Order;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final OrderRepository orderRepository;
    private final Faker faker;

    public SampleDataLoader(OrderRepository orderRepository, Faker faker) {
        this.orderRepository = orderRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) {

        List<Order> sampleOrders = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Order(
                        faker.code().isbn10(),
                        faker.number().numberBetween(1, 15),
                        faker.internet().emailAddress()

                )).collect(Collectors.toList());

        orderRepository.saveAll(sampleOrders);
    }
}
