package ru.netology.jdbcdemo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostgresRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public String findProductNameByCustomerName(String customerName) {
        return entityManager.createQuery("SELECT o.productName from Order o where o.customer.name = :customerName", String.class)
                .setParameter("customerName", customerName)
                .getSingleResult();
    }
}
