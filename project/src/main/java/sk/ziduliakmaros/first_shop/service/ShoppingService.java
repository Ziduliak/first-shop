package sk.ziduliakmaros.first_shop.service;


import sk.ziduliakmaros.first_shop.model.dto.controller.buyProduct.BuyProductRequest;
import sk.ziduliakmaros.first_shop.model.dto.controller.buyProduct.BuyProductResponse;

public interface ShoppingService {
    BuyProductResponse buyProduct(BuyProductRequest request);

}
