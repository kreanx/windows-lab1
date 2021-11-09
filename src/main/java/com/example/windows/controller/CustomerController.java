package com.example.windows.controller;

import com.example.windows.entity.Customer;
import com.example.windows.model.CustomerModel;
import com.example.windows.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.windows.dto.PageDto;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Customer>> getCustomers(PageDto pageDto) {
        return new ResponseEntity<>(customerService.getCustomers(pageDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerModel customerModel) {
        return new ResponseEntity<>(customerService.addCustomer(customerModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerModel customerModel) {
        return new ResponseEntity<>(customerService.updateCustomer(id, customerModel), HttpStatus.OK);
    }

    /*@DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }*/
}
