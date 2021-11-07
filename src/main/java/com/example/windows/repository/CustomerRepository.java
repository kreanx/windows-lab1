package com.example.windows.repository;

import com.example.windows.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByFullNameAndPhoneAndAddress(String fullName, String phone, String address);
}
