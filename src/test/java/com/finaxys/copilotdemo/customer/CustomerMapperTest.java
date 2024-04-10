package com.finaxys.copilotdemo.customer;

import com.finaxys.copilotdemo.customer.CustomerMapper;
import com.finaxys.copilotdemo.customer.model.CustomerDTO;
import com.finaxys.copilotdemo.customer.model.CustomerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerMapperTest {
    private CustomerMapper customerMapper;

    @BeforeEach
    public void setUp() {
        customerMapper = new CustomerMapper();
    }

    @Test
    public void testToDTO() {
        CustomerEntity entity = new CustomerEntity();
        entity.setCustomerId(1L);
        entity.setFirstName("John");
        entity.setLastName("Doe");
        entity.setAge(30);

        CustomerDTO dto = customerMapper.toDTO(entity);

        assertEquals(entity.getCustomerId(), dto.getCustomerId());
        assertEquals(entity.getFirstName(), dto.getFirstName());
        assertEquals(entity.getLastName(), dto.getLastName());
        assertEquals(entity.getAge(), dto.getAge());
    }

    @Test
    public void testToEntity() {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(1L);
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setAge(30);

        CustomerEntity entity = customerMapper.toEntity(dto);

        assertEquals(dto.getCustomerId(), entity.getCustomerId());
        assertEquals(dto.getFirstName(), entity.getFirstName());
        assertEquals(dto.getLastName(), entity.getLastName());
        assertEquals(dto.getAge(), entity.getAge());
    }

    @Test
    public void testToDTOList() {
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

        List<CustomerDTO> dtos = customerMapper.toDTOList(entities);

        for (int i = 0; i < entities.size(); i++) {
            assertEquals(entities.get(i).getCustomerId(), dtos.get(i).getCustomerId());
            assertEquals(entities.get(i).getFirstName(), dtos.get(i).getFirstName());
            assertEquals(entities.get(i).getLastName(), dtos.get(i).getLastName());
            assertEquals(entities.get(i).getAge(), dtos.get(i).getAge());
        }
    }

    @Test
    public void testToEntityList() {
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

        List<CustomerEntity> entities = customerMapper.toEntityList(dtos);

        for (int i = 0; i < dtos.size(); i++) {
            assertEquals(dtos.get(i).getCustomerId(), entities.get(i).getCustomerId());
            assertEquals(dtos.get(i).getFirstName(), entities.get(i).getFirstName());
            assertEquals(dtos.get(i).getLastName(), entities.get(i).getLastName());
            assertEquals(dtos.get(i).getAge(), entities.get(i).getAge());
        }
    }
}