package com.finaxys.copilotdemo.customer;

import com.finaxys.copilotdemo.customer.model.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private List<CustomerDTO> customerDTOList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.customerDTOList = Arrays.asList(
                new CustomerDTO(1L, "John", "Doe", 30),
                new CustomerDTO(2L, "Jane", "Doe", 25)
        );
    }

    @Test
    public void testGetAllCustomers() {
        when(customerService.getAllCustomers()).thenReturn(customerDTOList);

        ResponseEntity<List<CustomerDTO>> response = customerController.getAllCustomers();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(customerDTOList, response.getBody());
    }

    @Test
    public void testGetCustomerById() {
        when(customerService.getCustomerById(1L)).thenReturn(Optional.of(customerDTOList.get(0)));

        ResponseEntity<CustomerDTO> response = customerController.getCustomerById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(customerDTOList.get(0), response.getBody());
    }

    @Test
    public void testCreateCustomer() {
        when(customerService.createCustomer(customerDTOList.get(0))).thenReturn(customerDTOList.get(0));

        ResponseEntity<CustomerDTO> response = customerController.createCustomer(customerDTOList.get(0));

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(customerDTOList.get(0), response.getBody());
    }

    @Test
    public void testUpdateCustomer() {
        when(customerService.updateCustomer(customerDTOList.get(0))).thenReturn(customerDTOList.get(0));

        ResponseEntity<CustomerDTO> response = customerController.updateCustomer(customerDTOList.get(0));

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(customerDTOList.get(0), response.getBody());
    }

    @Test
    public void testDeleteCustomer() {
        ResponseEntity<Void> response = customerController.deleteCustomer(1L);

        assertEquals(204, response.getStatusCodeValue());
    }
}