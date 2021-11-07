package com.example.windows.service;

import com.example.windows.entity.Customer;
import com.example.windows.model.CustomerModel;

public interface CustomerService {
    Customer getCustomerById(Long id);

    //Page<Book> getBooks(PageDto pageDto);

    Customer addCustomer(CustomerModel customerModel);

    Customer updateCustomer(Long id, CustomerModel customerModel);

    void deleteCustomerById(Long id);
}
