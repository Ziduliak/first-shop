package sk.ziduliakmaros.first_shop.model.dto.controller.buyProduct;

import org.springframework.lang.Nullable;
import sk.ziduliakmaros.first_shop.model.dto.BoughtProductDto;


public class BuyProductResponse {
    private boolean success;
    @Nullable
    private String errorMessage;
    private BoughtProductDto boughtProductDto;
    private BoughtProductDto getBoughtProductDto(){return boughtProductDto;}

    public void setBoughtProductDto(BoughtProductDto boughtProductDto) {
        this.boughtProductDto = boughtProductDto;
    }

    public BuyProductResponse(boolean success) {
        this.success = success;
    }

    public BuyProductResponse(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public BuyProductResponse() {

    }

    public boolean isSuccess() {
        return true;
    }

    @Nullable
    public String getErrorMessage() {
        return errorMessage;
    }
}
