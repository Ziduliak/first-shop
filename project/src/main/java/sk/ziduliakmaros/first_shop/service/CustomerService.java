package sk.ziduliakmaros.first_shop.service;

import sk.ziduliakmaros.first_shop.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(String name,
                               String surname,
                               String email,
                               String address,
                               Integer age,
                               String phoneNumber);
    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomer(Integer id);

    void deleteCustomer(Integer id);



}
