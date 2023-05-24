package sk.ziduliakmaros.first_shop.model.dto.controller.customerAccount;


import sk.ziduliakmaros.first_shop.model.dto.CustomerAccountDto;

public class CustomerAccountResponse {
    private CustomerAccountDto account;

    public CustomerAccountDto getAccount() {
        return account;
    }

    public void setAccount(CustomerAccountDto account) {
        this.account = account;
    }
}
