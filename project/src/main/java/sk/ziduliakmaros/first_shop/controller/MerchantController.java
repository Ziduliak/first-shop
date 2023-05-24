package sk.ziduliakmaros.first_shop.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import sk.ziduliakmaros.first_shop.model.dto.MerchantDto;
import sk.ziduliakmaros.first_shop.model.dto.controller.merchant.AddMerchantRequest;
import sk.ziduliakmaros.first_shop.model.dto.controller.merchant.AddMerchantResponse;
import sk.ziduliakmaros.first_shop.service.MerchantService;


import java.util.List;

@RestController
@RequestMapping(path = "/merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping(path = "/addMerchant")
    public AddMerchantResponse addMerchant(@RequestBody @Valid AddMerchantRequest merchant){
        final AddMerchantResponse response = new AddMerchantResponse();
        response.setMerchant(merchantService.createMerchant(
                merchant.getName(),
                merchant.getEmail(),
                merchant.getAddress()
        ));
        return response;
    }

    @GetMapping(path = "/all")
    public List<MerchantDto> getMerchants() {
        return merchantService.getMerchants();
    }
    @GetMapping(path = "/{id}")
    public MerchantDto getCustomer(@NonNull @PathVariable("id") Integer id) {

        return merchantService.getMerchant(id);
    }
}
