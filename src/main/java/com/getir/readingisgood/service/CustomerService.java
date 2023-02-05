package com.getir.readingisgood.service;

import com.getir.readingisgood.dto.CustomerDto;
import com.getir.readingisgood.utilities.results.Result;

public interface CustomerService {

    Result addCustomer(CustomerDto customerDto);

}