package FoodDelivery.com.BYTES.Transformers;

import FoodDelivery.com.BYTES.dto.request.RestaurantRequest;
import FoodDelivery.com.BYTES.dto.response.FoodResponse;
import FoodDelivery.com.BYTES.dto.response.RestaurantResponse;
import FoodDelivery.com.BYTES.model.Food_Item;
import FoodDelivery.com.BYTES.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantTransformer {
    public static Restaurant RequestToModel(RestaurantRequest restaurantRequest){
        return Restaurant.builder()
                .name(restaurantRequest.getName())
                .mobile(restaurantRequest.getMobile())
                .email(restaurantRequest.getEmail())
                .restaurantCategory(restaurantRequest.getRestaurantCategory())
                .foodItemList(new ArrayList<>())
                .orderEntityList(new ArrayList<>())
                .build();
    }
    public static RestaurantResponse ModelToResponse(Restaurant restaurant){

        List<FoodResponse> foodResponseList =restaurant.getFoodItemList()
                .stream()
                .map(foodItem -> Food_ItemTransformer.ModelToResponse(foodItem))
                .collect(Collectors.toList());
        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .mobile(restaurant.getMobile())
                .email(restaurant.getEmail())
                .restaurantCategory(restaurant.getRestaurantCategory())
                .menu(foodResponseList)
                .build();
    }

}
