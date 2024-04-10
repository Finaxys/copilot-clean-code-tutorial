package com.finaxys.copilotdemo.customer;

import com.finaxys.copilotdemo.customer.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}