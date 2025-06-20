package ru.netology.jdbcdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final PostgresRepository repository;

    public String getProductName(String name) {
        return repository.findProductNameByCustomerName(name);
    }
}
