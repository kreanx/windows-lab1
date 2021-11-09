package com.example.windows.serviceimpl;

import com.example.windows.entity.*;
import com.example.windows.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.windows.exception.ResourceAlreadyExistsException;
import com.example.windows.exception.ResourceNotFoundException;
import com.example.windows.model.CustomerModel;
import com.example.windows.service.CustomerService;
import com.example.windows.dto.PageDto;
import org.springframework.data.domain.Page;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The customer with id " + id + " does not exist."));
    }

    @Override
    public Page<Customer> getCustomers(PageDto pageDto) {
        return customerRepository.findAll(pageDto.getPageable());
    }

    @Override
    public Customer addCustomer(CustomerModel customerModel) {
        if (customerRepository.existsByFullNameAndPhoneAndAddress(customerModel.getFullName(),customerModel.getPhone(),customerModel.getAddress())) {
            throw new ResourceAlreadyExistsException("This customer already exists.");
        }
        Customer customer = Customer.builder()
                .fullName(customerModel.getFullName())
                .phone(customerModel.getPhone())
                .address(customerModel.getAddress())
                .build();
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Long id, CustomerModel customerModel) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("The customer with id " + id + " does not exist.");
        }

        Customer customer = new Customer(id,customerModel.getFullName(),customerModel.getPhone(),customerModel.getAddress());
        customerRepository.save(customer);
        return customer;
    }
}
