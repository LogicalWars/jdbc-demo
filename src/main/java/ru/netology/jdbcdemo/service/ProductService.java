package ru.netology.jdbcdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.jdbcdemo.repository.PostgresRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final PostgresRepository repository;

    public String getProductName(String name) {
        return repository.findProductNameByCustomerName(name);
    }
}
