package sk.ziduliakmaros.first_shop.model.dto.controller.product;


import sk.ziduliakmaros.first_shop.model.dto.ProductDto;

public class AddProductResponse {
    private ProductDto product;

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
