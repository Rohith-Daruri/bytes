package FoodDelivery.com.BYTES.Transformers;

import FoodDelivery.com.BYTES.dto.request.Food_ItemRequest;
import FoodDelivery.com.BYTES.dto.response.FoodResponse;
import FoodDelivery.com.BYTES.model.Food_Item;

public class Food_ItemTransformer {
    public static Food_Item RequestToModel(Food_ItemRequest foodItemRequest){
        return Food_Item.builder()
                .name(foodItemRequest.getName())
                .category(foodItemRequest.getCategory())
                .veg(foodItemRequest.isVeg())
                .price(foodItemRequest.getPrice())
                .available(true)
                .build();
    }
    public static FoodResponse ModelToResponse(Food_Item foodItem){
        return FoodResponse.builder()
                .type(String.valueOf(foodItem.getAvailable()))
                .category(foodItem.getCategory())
                .price(foodItem.getPrice())
                .build();
    }
}
