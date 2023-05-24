package sk.ziduliakmaros.first_shop.mapper;


import org.springframework.stereotype.Service;
import sk.ziduliakmaros.first_shop.model.dto.CustomerAccountDto;
import sk.ziduliakmaros.first_shop.model.entity.CustomerAccountEntity;


@Service
public class CustomerAccountMapper {
    public CustomerAccountDto convertCustomerAccountToDto(CustomerAccountEntity entity){

        final CustomerAccountDto dto = new CustomerAccountDto();
        dto.setId(entity.getId());
        dto.setMoney(entity.getMoney());
        return dto;
    }

    public CustomerAccountEntity convertDtoToCustomerAccount(CustomerAccountDto dto){

        final CustomerAccountEntity entity = new CustomerAccountEntity();
        entity.setId(dto.getId());
        entity.setMoney(dto.getMoney());
        return entity;
    }
}
