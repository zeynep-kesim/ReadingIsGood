package com.getir.readingisgood.controller;

import com.getir.readingisgood.dto.CustomerDto;
import com.getir.readingisgood.service.CustomerService;
import com.getir.readingisgood.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomersController {

    private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addcustomer")
    public Result addCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }

}