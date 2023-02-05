package com.getir.readingisgood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int orderId;
    private LocalDateTime orderDate;
    private CustomerDto customerDto;
    private BookDto bookDto;

}