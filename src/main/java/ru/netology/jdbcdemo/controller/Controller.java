package ru.netology.jdbcdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbcdemo.service.ProductService;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ProductService productService;

    @GetMapping("/products/fetch-product")
    public ResponseEntity<?> getProducts(@RequestParam String name) {
        return ResponseEntity.ok().body(productService.getProductName(name));
    }
}
