package sk.ziduliakmaros.first_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.ziduliakmaros.first_shop.model.dto.BoughtProductDto;
import sk.ziduliakmaros.first_shop.service.BoughtProductService;


import java.util.List;

@RestController
@RequestMapping("/boughtProduct")
public class BoughtProductController {
    @Autowired
    private BoughtProductService service;

    @GetMapping(path = "/{id}")
    public List<BoughtProductDto> getAllByCustomerId(@NonNull @PathVariable("id") Integer customerId) {
        return service.getAllByCustomerId(customerId);
    }

}
