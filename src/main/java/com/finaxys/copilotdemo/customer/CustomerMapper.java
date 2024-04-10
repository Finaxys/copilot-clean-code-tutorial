package com.finaxys.copilotdemo.customer;

import com.finaxys.copilotdemo.customer.model.CustomerDTO;
import com.finaxys.copilotdemo.customer.model.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public CustomerDTO toDTO(CustomerEntity entity) {
        return CustomerDTO.builder()
                .customerId(entity.getCustomerId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .age(entity.getAge())
                .build();
    }

    public CustomerEntity toEntity(CustomerDTO dto) {
        return CustomerEntity.builder()
                .customerId(dto.getCustomerId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .build();
    }

    public List<CustomerDTO> toDTOList(List<CustomerEntity> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<CustomerEntity> toEntityList(List<CustomerDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}