package sk.ziduliakmaros.first_shop.model.dto.controller.merchant;


import sk.ziduliakmaros.first_shop.model.dto.MerchantDto;

public class AddMerchantResponse {
    private MerchantDto merchant;
    public MerchantDto getMerchant(){
        return merchant;
    }

    public void setMerchant(MerchantDto merchant) {
        this.merchant = merchant;
    }
}
