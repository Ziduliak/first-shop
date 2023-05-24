package sk.ziduliakmaros.first_shop.model.dto;

import java.math.BigDecimal;

public class CustomerAccountDto {
    private Integer id;
    private BigDecimal money;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerAccountDto() {
    }



    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
