package sk.ziduliakmaros.first_shop.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.ziduliakmaros.first_shop.mapper.ProductMapper;
import sk.ziduliakmaros.first_shop.model.dto.ProductDto;
import sk.ziduliakmaros.first_shop.model.dto.controller.product.UpdateProductRequest;
import sk.ziduliakmaros.first_shop.model.entity.MerchantEntity;
import sk.ziduliakmaros.first_shop.model.entity.ProductEntity;
import sk.ziduliakmaros.first_shop.repository.MerchantRepository;
import sk.ziduliakmaros.first_shop.repository.ProductRepository;
import sk.ziduliakmaros.first_shop.service.ProductService;


import javax.ws.rs.InternalServerErrorException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper mapper;

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(mapper::convertProductToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto get(Integer id) {
        return productRepository.findById(id)
                .map(product -> mapper.convertProductToDto(product))
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));
    }

    @Override
    public ProductDto add(Integer merchantId,
                          String name,
                          String description,
                          BigDecimal price,
                          Integer available) {

        final MerchantEntity merchantEntity = merchantRepository.findById(merchantId).orElse(null);

            final ProductEntity productEntity = new ProductEntity();
            productEntity.setMerchantEntity(merchantEntity);
            productEntity.setName(name);
            productEntity.setDescription(description);
            productEntity.setPrice(price);
            productEntity.setAvailable(available);

            return mapper.convertProductToDto(
                    productRepository.save(productEntity));
    }

    @Override
    public void delete(Integer id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Product with id " + id + " not found.");
            //logger.error("Could not delete customer with id: " + id + ". Customer not found.");
        } catch (DataAccessException e) {
            throw new InternalServerErrorException("Could not delete product with id: " + id);
            // logger.error("Could not delete customer with id: " + id + ". Error occurred: " + e.getMessage());
        }
    }

    @Override // toto este prerobit na Dto
    public void update(Integer id, UpdateProductRequest request) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
            // Update the fields of the product object using the fields of the request object
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setPrice(request.getPrice());
            product.setAvailable(request.getAvailable());
            productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    @Override  // aj toto
    public void updateAvailableInternal(Integer id, Integer newAvailable) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
            product.setAvailable(newAvailable);
            productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }
}
