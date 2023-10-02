package FoodDelivery.com.BYTES.utils;

import FoodDelivery.com.BYTES.Exception.RestaurantNotFound;
import FoodDelivery.com.BYTES.Repository.RestaurantRepository;
import FoodDelivery.com.BYTES.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class Validation {
    @Autowired
    final RestaurantRepository restaurantRepository;

    public Validation(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    public boolean RestaurantValidation(int Id){
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(Id);
        if(restaurantOptional.isEmpty()){
           return false;
        }
        return true;
    }
}
