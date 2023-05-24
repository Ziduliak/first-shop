package sk.ziduliakmaros.first_shop.mapper;

import org.springframework.stereotype.Service;
import sk.ziduliakmaros.first_shop.model.dto.MerchantDto;
import sk.ziduliakmaros.first_shop.model.entity.MerchantEntity;


@Service
public class MerchantMapper {
    public MerchantDto convertMerchantToDto(MerchantEntity merchantEntity){
        final MerchantDto dto = new MerchantDto();
        dto.setMerchantId(merchantEntity.getId());
        dto.setName(merchantEntity.getName());
        dto.setEmail(merchantEntity.getEmail());
        dto.setAddress(merchantEntity.getAddress());

        return dto;
    }

    public MerchantEntity convertMerchantDtoToMerchant(MerchantDto merchantDto){
        final MerchantEntity entity = new MerchantEntity();
        entity.setId(merchantDto.getMerchantId());
        entity.setName(merchantDto.getName());
        entity.setEmail(merchantDto.getEmail());
        entity.setAddress(merchantDto.getAddress());
        return entity;
    }
}
