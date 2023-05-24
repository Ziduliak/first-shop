package sk.ziduliakmaros.first_shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.ziduliakmaros.first_shop.mapper.BoughtProductMapper;
import sk.ziduliakmaros.first_shop.model.dto.BoughtProductDto;
import sk.ziduliakmaros.first_shop.model.entity.BoughtProductEntity;
import sk.ziduliakmaros.first_shop.repository.BoughtProductRepository;
import sk.ziduliakmaros.first_shop.repository.CustomerRepository;
import sk.ziduliakmaros.first_shop.repository.ProductRepository;
import sk.ziduliakmaros.first_shop.service.BoughtProductService;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BoughtProductImpl implements BoughtProductService {
    @Autowired
    BoughtProductRepository boughtProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BoughtProductMapper mapper;

    //toto je nové
    @Override
    public BoughtProductDto add(BoughtProductDto boughtProductDto) {
        Integer productId = boughtProductDto.getProductId();
        Integer customerId = boughtProductDto.getCustomerId();

        final BoughtProductEntity boughtProductEntity = new BoughtProductEntity();

        boughtProductEntity.setProductEntity(productRepository.findById(productId).orElse(null));
        boughtProductEntity.setCustomer(customerRepository.findById(customerId).orElse(null));
        boughtProductEntity.setQuantity(boughtProductDto.getQuantity());
        boughtProductEntity.setBoughtAt(boughtProductDto.getBoughtAt());

        return mapper.convertBPToDto(boughtProductRepository.save(boughtProductEntity));
    }

    @Override
    public List<BoughtProductDto> getAllByCustomerId(Integer customerId) {
       return boughtProductRepository.findById(customerId).stream()
                .map(boughtProduct -> mapper.convertBPToDto(boughtProduct))
               .collect(Collectors.toList());

    }
}
