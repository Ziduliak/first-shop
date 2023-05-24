package sk.ziduliakmaros.first_shop.service;



import sk.ziduliakmaros.first_shop.model.dto.BoughtProductDto;

import java.util.List;

public interface BoughtProductService {

    public BoughtProductDto add(BoughtProductDto boughtProductDto);

    List<BoughtProductDto> getAllByCustomerId(Integer customerId);
}
