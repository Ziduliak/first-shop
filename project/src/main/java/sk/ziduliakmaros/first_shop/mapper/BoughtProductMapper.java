package sk.ziduliakmaros.first_shop.mapper;

import org.springframework.stereotype.Service;
import sk.ziduliakmaros.first_shop.model.dto.BoughtProductDto;
import sk.ziduliakmaros.first_shop.model.entity.BoughtProductEntity;


@Service
public class BoughtProductMapper {
    public BoughtProductDto convertBPToDto(BoughtProductEntity boughtProductEntity){

        final BoughtProductDto dto = new BoughtProductDto();
        dto.setCustomerId(boughtProductEntity.getCustomer().getId());
        dto.setId(boughtProductEntity.getId());
       dto.setProductId(boughtProductEntity.getId());
       dto.setQuantity(boughtProductEntity.getQuantity());
       dto.setBoughtAt(boughtProductEntity.getBoughtAt());

        return dto;
    }

    public BoughtProductEntity convertBPDtoToEntity(BoughtProductDto boughtProductDto){
        final BoughtProductEntity entity = new BoughtProductEntity();
        entity.setId(boughtProductDto.getProductId());
        entity.setQuantity(boughtProductDto.getQuantity());
        entity.setBoughtAt(boughtProductDto.getBoughtAt());
        return entity;
    }
}
