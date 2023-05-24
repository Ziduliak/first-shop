package sk.ziduliakmaros.first_shop.service;




import sk.ziduliakmaros.first_shop.model.dto.CustomerAccountDto;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerAccountService {
     CustomerAccountDto createAccount(Integer customerId,
                                      BigDecimal money);
     BigDecimal getMoney(Integer customerId);

     void updateMoney(Integer customerId, BigDecimal money);

     CustomerAccountDto getCustomerAccount(Integer customerId);

    List<CustomerAccountDto> getAllCustomers();
}


