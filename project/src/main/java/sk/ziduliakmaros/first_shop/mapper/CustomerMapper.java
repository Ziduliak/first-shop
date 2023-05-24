package sk.ziduliakmaros.first_shop.mapper;

import org.springframework.stereotype.Service;
import sk.ziduliakmaros.first_shop.model.dto.CustomerDto;
import sk.ziduliakmaros.first_shop.model.entity.CustomerEntity;


@Service
public class CustomerMapper {

    public CustomerDto convertCustomerToDto(CustomerEntity customerEntity) {

        final CustomerDto dto = new CustomerDto();

        dto.setCustomerId(customerEntity.getId());
        dto.setName(customerEntity.getName());
        dto.setSurname(customerEntity.getSurname());
        dto.setEmail(customerEntity.getEmail());
        dto.setAge(customerEntity.getAge());
        dto.setAddress(customerEntity.getAddress());
        dto.setPhoneNumber(customerEntity.getPhoneNumber());
        return dto;
    }

    public CustomerEntity convertCustomerDtoToCustomer(CustomerDto customerDto) {

    final CustomerEntity entity = new CustomerEntity();

    entity.setId(customerDto.getCustomerId());
    entity.setName(customerDto.getName());
    entity.setSurname(customerDto.getSurname());
    entity.setEmail(customerDto.getEmail());
    entity.setAge(customerDto.getAge());
    entity.setPhoneNumber(customerDto.getPhoneNumber());

    return entity;
    };
}
