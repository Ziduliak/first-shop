package sk.ziduliakmaros.first_shop.service;



import sk.ziduliakmaros.first_shop.model.dto.MerchantDto;

import java.util.List;

public interface MerchantService {
    List<MerchantDto> getMerchants();

    MerchantDto getMerchant(Integer id);

    MerchantDto createMerchant(String name,
                               String email,
                               String address);
}
