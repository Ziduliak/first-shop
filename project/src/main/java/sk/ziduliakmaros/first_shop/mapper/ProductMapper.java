package sk.ziduliakmaros.first_shop.mapper;

import org.springframework.stereotype.Service;
import sk.ziduliakmaros.first_shop.model.dto.ProductDto;
import sk.ziduliakmaros.first_shop.model.entity.ProductEntity;
import sk.ziduliakmaros.first_shop.repository.MerchantRepository;


@Service
public class ProductMapper {

    private final MerchantRepository merchantRepository;

    public ProductMapper(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public ProductDto convertProductToDto(ProductEntity productEntity) {

        final ProductDto dto = new ProductDto();

        dto.setId(productEntity.getId());
        dto.setMerchantId(productEntity.getMerchantEntity().getId());
        dto.setName(productEntity.getName());
        dto.setDescription(productEntity.getDescription());
        dto.setPrice(productEntity.getPrice());
        dto.setCreatedAt(productEntity.getCreatedAt());
        dto.setAvailable(productEntity.getAvailable());
        return dto;
    }
    public ProductEntity convertProductDtoToProduct(ProductDto productDto) {

        final ProductEntity entity = new ProductEntity();

        entity.setId(productDto.getId());
        entity.setMerchantEntity(merchantRepository.findById(productDto.getMerchantId()).orElse(null));
        entity.setName(productDto.getName());
        entity.setDescription(productDto.getDescription());
        entity.setPrice(productDto.getPrice());
        entity.setPrice(productDto.getPrice());
        entity.setCreatedAt(productDto.getCreatedAt());
        entity.setAvailable(productDto.getAvailable());
        return entity;
    };
}
