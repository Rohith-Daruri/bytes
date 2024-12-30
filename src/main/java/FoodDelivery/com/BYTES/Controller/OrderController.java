package FoodDelivery.com.BYTES.Controller;

import FoodDelivery.com.BYTES.Service.OrderService;
import FoodDelivery.com.BYTES.dto.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/add/{id}")
        public ResponseEntity add_Order(@PathVariable("id")int customerId){
            OrderResponse orderResponse = orderService.add_Order(customerId);
            return new ResponseEntity(orderResponse, HttpStatus.CREATED);
        }

}
