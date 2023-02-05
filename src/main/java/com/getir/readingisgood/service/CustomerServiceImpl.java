package com.getir.readingisgood.service;

import com.getir.readingisgood.dao.CustomerDao;
import com.getir.readingisgood.dto.CustomerDto;
import com.getir.readingisgood.model.Customer;
import com.getir.readingisgood.utilities.constants.Messages;
import com.getir.readingisgood.utilities.results.Result;
import com.getir.readingisgood.utilities.results.SuccessResult;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private CustomerDao customerDao;

    private ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao, ModelMapper modelMapper) {
        this.customerDao = customerDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result addCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customerDao.save(customer);
        logger.info("Customer Name : " + customerDto.getCustomerName(), "Customer Surname :" + customerDto.getCustomerSurname());
        return new SuccessResult(Messages.CUSTOMER_ADDED);
    }

}