package com.getir.readingisgood.service;

import com.getir.readingisgood.dto.OrderDto;
import com.getir.readingisgood.utilities.results.Result;

public interface OrderService {

    Result addOrder(OrderDto orderDto);

    OrderDto orderById(int orderId);

}