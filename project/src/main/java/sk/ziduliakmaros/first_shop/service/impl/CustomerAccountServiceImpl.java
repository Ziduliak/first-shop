package sk.ziduliakmaros.first_shop.service.impl;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.ziduliakmaros.first_shop.mapper.CustomerAccountMapper;
import sk.ziduliakmaros.first_shop.model.dto.CustomerAccountDto;
import sk.ziduliakmaros.first_shop.model.entity.CustomerAccountEntity;
import sk.ziduliakmaros.first_shop.model.entity.CustomerEntity;
import sk.ziduliakmaros.first_shop.repository.CustomerAccountRepository;
import sk.ziduliakmaros.first_shop.repository.CustomerRepository;
import sk.ziduliakmaros.first_shop.service.CustomerAccountService;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerAccountServiceImpl implements CustomerAccountService {
    @Autowired
    private CustomerAccountRepository customerAccountRepository;
    @Autowired
    private CustomerAccountMapper customerAccountMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerAccountDto createAccount(Integer customerId, BigDecimal money) {
        if (customerId == null) {
            throw new IllegalArgumentException("customerId cannot be null");
        }

        final Optional<CustomerEntity> customerEntity = customerRepository.findById(customerId);

        if (customerEntity.isEmpty()) {
            throw new EntityNotFoundException("Customer with id " + customerId + " does not exist!");
        }

        final CustomerAccountEntity accountEntity = new CustomerAccountEntity();
        accountEntity.setCustomer(customerEntity.get());
        accountEntity.setMoney(money);

        return customerAccountMapper.convertCustomerAccountToDto(customerAccountRepository.save(accountEntity));
    }

    @Override
    public BigDecimal getMoney(Integer customerId) {
        return customerAccountRepository.getMoney(customerId);
    }


    @Override
    public void updateMoney(Integer customerId, BigDecimal money) {
        customerAccountRepository.findById(customerId)
                .ifPresent(customerAccount -> {
                    customerAccount.setMoney(money);
                });
    }

    @Override
    public CustomerAccountDto getCustomerAccount(Integer customerId) {
        return customerAccountRepository.findById(customerId)
                .map(customer -> customerAccountMapper.convertCustomerAccountToDto(customer))
                .orElseThrow(() -> new EntityNotFoundException("Customer with id " + customerId + " not found"));
    }

    @Override
    public List<CustomerAccountDto> getAllCustomers() {
        return customerAccountRepository.findAll().stream()
                .map(customerAccountMapper::convertCustomerAccountToDto)
                .collect(Collectors.toList());
    }
}
