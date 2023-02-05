package com.getir.readingisgood.controller;

import com.getir.readingisgood.dto.OrderDto;
import com.getir.readingisgood.service.OrderService;
import com.getir.readingisgood.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrdersController {

    private OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addorder")
    public Result addOrder(@Valid @RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    @PostMapping("/orderbyid")
    public OrderDto orderById(@Valid @RequestBody int orderId) {
        return orderService.orderById(orderId);
    }

}