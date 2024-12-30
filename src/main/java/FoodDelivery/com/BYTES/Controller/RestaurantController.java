package FoodDelivery.com.BYTES.Controller;

import FoodDelivery.com.BYTES.Exception.RestaurantNotFound;
import FoodDelivery.com.BYTES.Service.RestaurantService;
import FoodDelivery.com.BYTES.dto.request.MenuItemRequest;
import FoodDelivery.com.BYTES.dto.request.RestaurantRequest;
import FoodDelivery.com.BYTES.dto.response.RestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    @PostMapping("/add")
    public ResponseEntity addRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
        return new ResponseEntity(restaurantResponse, HttpStatus.CREATED);
    }
    @PutMapping("/update/status/{id}")
    public String updateStatus(@PathVariable("id")int id){
        String message = restaurantService.updateStatus(id);
        return message;
    }
    @PostMapping("/add/menu/{id}")
    public ResponseEntity addFoodToMenu(@RequestBody MenuItemRequest foodItemRequest, @PathVariable("id") int id){
        try {
            RestaurantResponse restaurantResponse = restaurantService.addMenuItem(foodItemRequest,id);
            return new ResponseEntity(restaurantResponse, HttpStatus.CREATED);
        }
        catch(RestaurantNotFound e){
            return new ResponseEntity(e.toString(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get/restaurant/{id}")
    public ResponseEntity getRestaurant(@PathVariable int id){
        RestaurantResponse restaurantResponse = restaurantService.getRestaurant(id);
        return new ResponseEntity(restaurantResponse,HttpStatus.FOUND);
    }
}
