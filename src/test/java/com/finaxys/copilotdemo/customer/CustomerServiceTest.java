package com.finaxys.copilotdemo.customer;

import com.finaxys.copilotdemo.customer.model.CustomerDTO;
import com.finaxys.copilotdemo.customer.model.CustomerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {
    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCustomer() {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(1L);
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setAge(30);

        CustomerEntity entity = new CustomerEntity();
        entity.setCustomerId(1L);
        entity.setFirstName("John");
        entity.setLastName("Doe");
        entity.setAge(30);

        when(customerMapper.toEntity(dto)).thenReturn(entity);
        when(customerRepository.save(entity)).thenReturn(entity);
        when(customerMapper.toDTO(entity)).thenReturn(dto);

        CustomerDTO result = customerService.createCustomer(dto);

        assertEquals(dto, result);
        verify(customerRepository, times(1)).save(entity);
    }

    @Test
    public void testGetCustomerById() {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(1L);
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setAge(30);

        CustomerEntity entity = new CustomerEntity();
        entity.setCustomerId(1L);
        entity.setFirstName("John");
        entity.setLastName("Doe");
        entity.setAge(30);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(customerMapper.toDTO(entity)).thenReturn(dto);

        Optional<CustomerDTO> result = customerService.getCustomerById(1L);

        assertEquals(Optional.of(dto), result);
        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetAllCustomers() {
        CustomerDTO dto1 = new CustomerDTO();
        dto1.setCustomerId(1L);
        dto1.setFirstName("John");
        dto1.setLastName("Doe");
        dto1.setAge(30);

        CustomerDTO dto2 = new CustomerDTO();
        dto2.setCustomerId(2L);
        dto2.setFirstName("Jane");
        dto2.setLastName("Doe");
        dto2.setAge(25);

        List<CustomerDTO> dtos = Arrays.asList(dto1, dto2);

        CustomerEntity entity1 = new CustomerEntity();
        entity1.setCustomerId(1L);
        entity1.setFirstName("John");
        entity1.setLastName("Doe");
        entity1.setAge(30);

        CustomerEntity entity2 = new CustomerEntity();
        entity2.setCustomerId(2L);
        entity2.setFirstName("Jane");
        entity2.setLastName("Doe");
        entity2.setAge(25);

        List<CustomerEntity> entities = Arrays.asList(entity1, entity2);

        when(customerRepository.findAll()).thenReturn(entities);
        when(customerMapper.toDTOList(entities)).thenReturn(dtos);

        List<CustomerDTO> result = customerService.getAllCustomers();

        assertEquals(dtos, result);
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateCustomer() {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(1L);
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setAge(30);

        CustomerEntity entity = new CustomerEntity();
        entity.setCustomerId(1L);
        entity.setFirstName("John");
        entity.setLastName("Doe");
        entity.setAge(30);

        when(customerMapper.toEntity(dto)).thenReturn(entity);
        when(customerRepository.save(entity)).thenReturn(entity);
        when(customerMapper.toDTO(entity)).thenReturn(dto);

        CustomerDTO result = customerService.updateCustomer(dto);

        assertEquals(dto, result);
        verify(customerRepository, times(1)).save(entity);
    }

    @Test
    public void testDeleteCustomer() {
        customerService.deleteCustomer(1L);
        verify(customerRepository, times(1)).deleteById(1L);
    }
}