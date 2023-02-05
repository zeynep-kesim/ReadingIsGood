package com.getir.readingisgood.dao;

import com.getir.readingisgood.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

    Order findBy();

}