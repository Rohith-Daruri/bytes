package FoodDelivery.com.BYTES.Service;

import FoodDelivery.com.BYTES.Exception.RestaurantNotFound;
import FoodDelivery.com.BYTES.Repository.RestaurantRepository;
import FoodDelivery.com.BYTES.Transformers.MenuItemTransformer;
import FoodDelivery.com.BYTES.Transformers.RestaurantTransformer;
import FoodDelivery.com.BYTES.dto.request.MenuItemRequest;
import FoodDelivery.com.BYTES.dto.request.RestaurantRequest;
import FoodDelivery.com.BYTES.dto.response.RestaurantResponse;
import FoodDelivery.com.BYTES.model.Menu_Item;
import FoodDelivery.com.BYTES.model.Restaurant;
import FoodDelivery.com.BYTES.utils.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    Validation validation;
    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = RestaurantTransformer.RequestToModel(restaurantRequest);
        restaurant.setOpen(true);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        RestaurantResponse restaurantResponse = RestaurantTransformer.ModelToResponse(savedRestaurant);
        return restaurantResponse;
    }


    public String updateStatus(int id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if(restaurantOptional.isPresent()){
            Restaurant restaurant = restaurantOptional.get();
            boolean val = restaurant.getOpen();
            restaurant.setOpen(!val);
            restaurantRepository.save(restaurant);
            return "Restaurant Opened changed successfully to "+restaurant.getOpen();
        }
        return "No Restaurant Found!!!";
    }

    public RestaurantResponse addMenuItem(MenuItemRequest foodItemRequest, int id) {
        boolean value = validation.RestaurantValidation(id);
        if(!value){
            throw new RestaurantNotFound("Restaurant Not Found!!!");
        }
        Restaurant restaurant = restaurantRepository.findById(id).get();
        Menu_Item foodItem = MenuItemTransformer.RequestToModel(foodItemRequest);
        foodItem.setRestaurant(restaurant);
        restaurant.getMenuItemList().add(foodItem);
        Restaurant savedrestaurant = restaurantRepository.save(restaurant);
        return RestaurantTransformer.ModelToResponse(savedrestaurant);
    }

    public RestaurantResponse getRestaurant(int id) {
        boolean value = validation.RestaurantValidation(id);
        if(!value){
            throw new RestaurantNotFound("Restaurant Not Found!!!");
        }
        Restaurant restaurant = restaurantRepository.findById(id).get();
        return RestaurantTransformer.ModelToResponse(restaurant);
    }
}
