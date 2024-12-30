package FoodDelivery.com.BYTES.Transformers;

import FoodDelivery.com.BYTES.dto.request.FoodRequest;
import FoodDelivery.com.BYTES.dto.response.FoodResponse;
import FoodDelivery.com.BYTES.model.Food_Item;

public class FoodTransformer {
    public static Food_Item RequestToModel(FoodRequest foodRequest){
        return Food_Item.builder()
                .quantity(foodRequest.getQuantity())
                .build();
    }
    public static FoodResponse ModelToResponse(Food_Item foodItem){
        return FoodResponse.builder()
                .Price(foodItem.getPrice())
                .RestaurantName(foodItem.getMenuItem().getRestaurant().getName())
                .CustomerEmail(foodItem.getCart().getCustomer().getEmail())
                .CustomerId(foodItem.getCart().getCustomer().getId())
                .build();
    }
}
