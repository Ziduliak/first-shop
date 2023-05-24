package sk.ziduliakmaros.first_shop.model.dto.controller.customerAccount;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CustomerAccountRequest {
    @NotNull
   private Integer customerId;
    @NotNull
    private BigDecimal money;


    public BigDecimal getMoney() {
        return money;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
