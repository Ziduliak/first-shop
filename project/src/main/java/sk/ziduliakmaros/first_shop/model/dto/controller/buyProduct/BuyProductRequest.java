package sk.ziduliakmaros.first_shop.model.dto.controller.buyProduct;

import jakarta.validation.constraints.NotNull;

public class BuyProductRequest {
    @NotNull
    private Integer productId;
    @NotNull
    private Integer customerId;
    @NotNull
    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
