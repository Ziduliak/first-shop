package sk.ziduliakmaros.first_shop.service;



import sk.ziduliakmaros.first_shop.model.dto.ProductDto;
import sk.ziduliakmaros.first_shop.model.dto.controller.product.UpdateProductRequest;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();

    ProductDto get(Integer id);

    public ProductDto add(Integer merchantId,
                          String name,
                          String description,
                          BigDecimal price,
                          Integer available);
    void delete(Integer id);

    void update(Integer id, UpdateProductRequest request);

    void updateAvailableInternal(Integer id, Integer newAvailable);
}
