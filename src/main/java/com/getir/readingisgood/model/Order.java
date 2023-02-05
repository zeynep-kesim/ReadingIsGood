package com.getir.readingisgood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JoinColumn(name = "book_id")
    private Book book;

}