package FoodDelivery.com.BYTES.Transformers;

import FoodDelivery.com.BYTES.dto.request.MenuItemRequest;
import FoodDelivery.com.BYTES.dto.response.MenuResponse;
import FoodDelivery.com.BYTES.model.Menu_Item;

public class MenuItemTransformer {
    public static Menu_Item RequestToModel(MenuItemRequest menuItemRequest){
        return Menu_Item.builder()
                .name(menuItemRequest.getName())
                .category(menuItemRequest.getCategory())
                .veg(menuItemRequest.isVeg())
                .price(menuItemRequest.getPrice())
                .available(true)
                .build();
    }
    public static MenuResponse ModelToResponse(Menu_Item menuItem){
        return MenuResponse.builder()
                .type(String.valueOf(menuItem.getAvailable()))
                .category(menuItem.getCategory())
                .price(menuItem.getPrice())
                .build();
    }
}
