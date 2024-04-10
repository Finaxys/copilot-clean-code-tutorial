package com.finaxys.copilotdemo.customer;

import com.finaxys.copilotdemo.customer.CustomerMapper;
import com.finaxys.copilotdemo.customer.model.CustomerDTO;
import com.finaxys.copilotdemo.customer.model.CustomerEntity;
import com.finaxys.copilotdemo.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerMapper.toEntity(customerDTO);
        CustomerEntity savedEntity = customerRepository.save(customerEntity);
        return customerMapper.toDTO(savedEntity);
    }

    public Optional<CustomerDTO> getCustomerById(Long id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerMapper::toDTO);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerMapper.toDTOList(customerEntities);
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerMapper.toEntity(customerDTO);
        CustomerEntity updatedEntity = customerRepository.save(customerEntity);
        return customerMapper.toDTO(updatedEntity);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}