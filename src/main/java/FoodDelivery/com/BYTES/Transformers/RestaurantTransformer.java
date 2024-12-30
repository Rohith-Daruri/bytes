package FoodDelivery.com.BYTES.Transformers;

import FoodDelivery.com.BYTES.dto.request.RestaurantRequest;
import FoodDelivery.com.BYTES.dto.response.MenuResponse;
import FoodDelivery.com.BYTES.dto.response.RestaurantResponse;
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
                .menuItemList(new ArrayList<>())
                .orderEntityList(new ArrayList<>())
                .build();
    }
    public static RestaurantResponse ModelToResponse(Restaurant restaurant){

        List<MenuResponse> MenuResponseList =restaurant.getMenuItemList()
                .stream()
                .map(foodItem -> MenuItemTransformer.ModelToResponse(foodItem))
                .collect(Collectors.toList());
        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .mobile(restaurant.getMobile())
                .email(restaurant.getEmail())
                .restaurantCategory(restaurant.getRestaurantCategory())
                .menu(MenuResponseList)
                .build();
    }

}
