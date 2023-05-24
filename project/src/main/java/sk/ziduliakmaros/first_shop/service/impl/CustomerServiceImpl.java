package sk.ziduliakmaros.first_shop.service.impl;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.ziduliakmaros.first_shop.mapper.CustomerMapper;
import sk.ziduliakmaros.first_shop.model.dto.CustomerDto;
import sk.ziduliakmaros.first_shop.model.entity.CustomerEntity;
import sk.ziduliakmaros.first_shop.repository.CustomerRepository;
import sk.ziduliakmaros.first_shop.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.InternalServerErrorException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper customerMapper;

    @Override
   // @Transactional(readOnly = true)                   neukladalo do db, iba zobrazilo,ale neuložilo
    public CustomerDto createCustomer(String name,
                                      String surname,
                                      String email,
                                      String address,
                                      Integer age,
                                      String phoneNumber) {
        final CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(name);
        customerEntity.setSurname(surname);
        customerEntity.setEmail(email);
        customerEntity.setAddress(address);
        customerEntity.setAge(age);
        customerEntity.setPhoneNumber(phoneNumber);

        return customerMapper.convertCustomerToDto(
                customerRepository.save(customerEntity));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDto> getAllCustomers() {

        return customerRepository.findAll().stream()
                .map(customerMapper::convertCustomerToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDto getCustomer(Integer id) {
        return customerRepository.findById(id)
                .map(customer -> customerMapper.convertCustomerToDto(customer))
                .orElseThrow(()->new EntityNotFoundException("Customer with "+id+"is not found"));
    }

    @Override
    public void deleteCustomer(Integer id) {
        try {
            customerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Customer with id " + id + " not found.");
            //logger.error("Could not delete customer with id: " + id + ". Customer not found.");
        } catch (DataAccessException e) {
            throw new InternalServerErrorException("Could not delete customer with id: " + id);
            // logger.error("Could not delete customer with id: " + id + ". Error occurred: " + e.getMessage());
        }
    }


}
