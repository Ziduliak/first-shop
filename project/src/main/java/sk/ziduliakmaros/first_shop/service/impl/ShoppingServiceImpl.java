package sk.ziduliakmaros.first_shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.ziduliakmaros.first_shop.model.dto.BoughtProductDto;
import sk.ziduliakmaros.first_shop.model.dto.CustomerDto;
import sk.ziduliakmaros.first_shop.model.dto.ProductDto;
import sk.ziduliakmaros.first_shop.model.dto.controller.buyProduct.BuyProductRequest;
import sk.ziduliakmaros.first_shop.model.dto.controller.buyProduct.BuyProductResponse;
import sk.ziduliakmaros.first_shop.service.*;


import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerAccountService customerAccountService;
    @Autowired
    private BoughtProductService boughtProductService;

    @Override
    public BuyProductResponse buyProduct(BuyProductRequest request) {
        Integer productId = request.getProductId();
        Integer customerId = request.getCustomerId();


        ProductDto product = productService.get(productId);
        if (product == null) {
            return new BuyProductResponse(false, "Product with id: " + productId + " doesn't exist");
        }

        CustomerDto customer = customerService.getCustomer(customerId);
        if (customer == null) {
            return new BuyProductResponse(false, "Customer with id: " + customerId + " doesn't exist");
        }

        if (product.getAvailable() < request.getQuantity()) {
            return new BuyProductResponse(false, "Not enough products in stock");
        }


        BigDecimal customerMoney = customerAccountService.getMoney(customerId);
        if (customerMoney == null) {
            return new BuyProductResponse(false, "Customer with id: " + customerId + " doesn't have account");
        } else {

            BigDecimal totalPriceOfRequest = product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity()));
            if (customerMoney.compareTo(totalPriceOfRequest) > -1) {

                productService.updateAvailableInternal(productId, product.getAvailable() - request.getQuantity());
                customerAccountService.updateMoney(customerId, customerMoney.divide(totalPriceOfRequest, RoundingMode.HALF_EVEN));
                boughtProductService.add(
                        new BoughtProductDto(
                        productId,
                        customerId,
                        request.getQuantity()));

                return new BuyProductResponse(true);

            } else {
                return new BuyProductResponse(false, "Customer with id: " + customerId + " doesn't have enough money");
            }}
    }




}
