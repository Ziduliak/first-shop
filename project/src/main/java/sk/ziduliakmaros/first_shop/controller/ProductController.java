package sk.ziduliakmaros.first_shop.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import sk.ziduliakmaros.first_shop.model.dto.ProductDto;
import sk.ziduliakmaros.first_shop.model.dto.controller.product.AddProductRequest;
import sk.ziduliakmaros.first_shop.model.dto.controller.product.AddProductResponse;
import sk.ziduliakmaros.first_shop.service.ProductService;


import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/addProduct")
    public AddProductResponse addProduct(@RequestBody @Valid AddProductRequest product) {
        final AddProductResponse response = new AddProductResponse();

        response.setProduct(productService.add(
                product.getMerchantId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAvailable()));

        return response;
    }
    @GetMapping(path = "/all")
    public List<ProductDto> getAllCustomers() {
        // This returns a JSON or XML with the users
        return productService.getProducts();
    }
    @GetMapping(path = "/{id}")
    public ProductDto getProduct(@NonNull @PathVariable("id") Integer id) {
        return productService.get(id);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Integer id){
        productService.delete(id);
    }
}
