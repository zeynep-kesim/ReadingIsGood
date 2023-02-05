package com.getir.readingisgood.service;

import com.getir.readingisgood.dao.OrderDao;
import com.getir.readingisgood.dto.OrderDto;
import com.getir.readingisgood.model.Order;
import com.getir.readingisgood.utilities.constants.Messages;
import com.getir.readingisgood.utilities.results.Result;
import com.getir.readingisgood.utilities.results.SuccessResult;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    private OrderDao orderDao;

    private ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, ModelMapper modelMapper) {
        this.orderDao = orderDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result addOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        orderDao.save(order);
        logger.info(orderDto.toString());
        return new SuccessResult(Messages.ORDER_ADDED);
    }

    @Override
    public OrderDto orderById(int orderId) {
        Order order = orderDao.findBy();
        return modelMapper.map(order, OrderDto.class);
    }

}