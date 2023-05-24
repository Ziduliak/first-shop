package sk.ziduliakmaros.first_shop.model.dto.controller.merchant;

import jakarta.validation.constraints.NotBlank;

public class AddMerchantRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
