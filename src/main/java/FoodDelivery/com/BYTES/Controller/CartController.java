package FoodDelivery.com.BYTES.Controller;

import FoodDelivery.com.BYTES.Service.CartService;
import FoodDelivery.com.BYTES.Service.OrderService;
import FoodDelivery.com.BYTES.dto.request.FoodRequest;
import FoodDelivery.com.BYTES.dto.response.FoodResponse;
import FoodDelivery.com.BYTES.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    OrderService orderService;
    @PostMapping("/add/food/{cid}/{mid}")
    public ResponseEntity addFoodToCart(@RequestBody FoodRequest foodRequest, @PathVariable("cid")int CustomerId,@PathVariable("mid")int MenuId){
        FoodResponse foodResponse = cartService.addFoodToCart(foodRequest,CustomerId,MenuId);
        return new ResponseEntity(foodResponse, HttpStatus.CREATED);
    }
    @PutMapping("/Clearcart")
    public String clear(@PathVariable("id") int customerId){
        cartService.clear(customerId);
        return "Cart reset Successfull";
    }
}
