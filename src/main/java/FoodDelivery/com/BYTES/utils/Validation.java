package FoodDelivery.com.BYTES.utils;

import FoodDelivery.com.BYTES.Repository.CustomerRepository;
import FoodDelivery.com.BYTES.Repository.MenuItemRepository;
import FoodDelivery.com.BYTES.Repository.RestaurantRepository;
import FoodDelivery.com.BYTES.model.Customer;
import FoodDelivery.com.BYTES.model.Menu_Item;
import FoodDelivery.com.BYTES.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Optional;
@Component
public class Validation {
    @Autowired
    final RestaurantRepository restaurantRepository;

    public Validation(RestaurantRepository restaurantRepository, CustomerRepository customerRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.customerRepository = customerRepository;
        this.menuItemRepository = menuItemRepository;
    }
   @Autowired
   final CustomerRepository customerRepository;
    @Autowired
    final MenuItemRepository menuItemRepository;
    public boolean RestaurantValidation(int Id){
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(Id);
        if(restaurantOptional.isEmpty()){
           return false;
        }
        return true;
    }
    public boolean CustomerValidation(int Id){
        Optional<Customer> customerOptional = customerRepository.findById(Id);
        if(customerOptional.isEmpty()){
            return false;
        }
        return true;
    }
    public boolean MenuValidation(int Id){
        Optional<Menu_Item> menuOptional = menuItemRepository.findById(Id);
        if(menuOptional.isEmpty()){
            return false;
        }
        Menu_Item menuItem = menuOptional.get();
        if(!menuItem.getAvailable()){
            return false;
        }
        return true;
    }

}
