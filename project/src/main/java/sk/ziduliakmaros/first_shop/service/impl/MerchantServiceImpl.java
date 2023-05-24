package sk.ziduliakmaros.first_shop.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.ziduliakmaros.first_shop.mapper.MerchantMapper;
import sk.ziduliakmaros.first_shop.model.dto.MerchantDto;
import sk.ziduliakmaros.first_shop.model.entity.MerchantEntity;
import sk.ziduliakmaros.first_shop.repository.MerchantRepository;
import sk.ziduliakmaros.first_shop.service.MerchantService;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    MerchantRepository merchantRepository;
    @Autowired
    MerchantMapper mapper;
    @Override
    public List<MerchantDto> getMerchants() {

        return merchantRepository.findAll().stream()
                .map(mapper::convertMerchantToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MerchantDto getMerchant(Integer id) {

        return merchantRepository.findById(id)
                .map(merchantEntity -> mapper.convertMerchantToDto(merchantEntity))
                .orElseThrow(() -> new EntityNotFoundException("Merchant with id" +id + "not found"));
    }

    @Override
    public MerchantDto createMerchant(String name,
                                      String email,
                                      String address) {
        final MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setName(name);
        merchantEntity.setEmail(email);
        merchantEntity.setAddress(address);
        return mapper.convertMerchantToDto(merchantRepository.save(merchantEntity));
    }
}
