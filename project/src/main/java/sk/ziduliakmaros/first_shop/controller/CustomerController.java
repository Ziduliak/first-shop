package sk.ziduliakmaros.first_shop.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import sk.ziduliakmaros.first_shop.model.dto.CustomerDto;
import sk.ziduliakmaros.first_shop.model.dto.controller.customer.AddCustomerRequest;
import sk.ziduliakmaros.first_shop.model.dto.controller.customer.AddCustomerResponse;
import sk.ziduliakmaros.first_shop.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @PostMapping(path = "/addCustomer")
    public AddCustomerResponse addCustomer(@RequestBody @Valid AddCustomerRequest customer) {
        final AddCustomerResponse response = new AddCustomerResponse();

        response.setCustomer(customerService.createCustomer(
                customer.getName(),
                customer.getSurname(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getAge(),
                customer.getPhoneNumber()));

        return response;
    }


    @GetMapping(path = "/all")
    public List<CustomerDto> getAllCustomers() {
        // This returns a JSON or XML with the users
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/{id}")
    public CustomerDto getCustomer(@NonNull @PathVariable("id") Integer id) {

        return customerService.getCustomer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id){
        customerService.deleteCustomer(id);
    }


}

