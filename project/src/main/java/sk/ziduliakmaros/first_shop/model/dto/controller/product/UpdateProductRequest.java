package sk.ziduliakmaros.first_shop.model.dto.controller.product;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public class UpdateProductRequest {

    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private BigDecimal price;
    @NonNull
    private Integer available;

    public UpdateProductRequest(String name, String description, BigDecimal price, Integer available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @NonNull
    public BigDecimal getPrice() {
        return price;
    }

    public int getAvailable() {
        return available;
    }


}
