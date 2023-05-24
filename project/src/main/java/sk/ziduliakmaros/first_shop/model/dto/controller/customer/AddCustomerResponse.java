package sk.ziduliakmaros.first_shop.model.dto.controller.customer;


import sk.ziduliakmaros.first_shop.model.dto.CustomerDto;

public class AddCustomerResponse {

    private CustomerDto customer;

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }
}
