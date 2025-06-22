package ru.netology.jdbcdemo.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders", schema = "netology")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date", columnDefinition = "timestamptz default now()")
    private OffsetDateTime date;

    @Column(name = "product_name", length = 50)
    private String productName;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
