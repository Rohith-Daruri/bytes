package FoodDelivery.com.BYTES.Controller;

import FoodDelivery.com.BYTES.Enum.Gender;
import FoodDelivery.com.BYTES.Exception.GenderException;
import FoodDelivery.com.BYTES.Service.CustomerService;
import FoodDelivery.com.BYTES.dto.request.CustomerRequest;
import FoodDelivery.com.BYTES.dto.response.CustomerResponse;
import FoodDelivery.com.BYTES.model.Customer;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) throws MessagingException {
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
        return new ResponseEntity(customerResponse, HttpStatus.CREATED);
    }
    @GetMapping("/getByGender/{gender}")
    public ResponseEntity getByGender(@PathVariable("gender")Gender gender){
        try{
            List<CustomerResponse> customerList = customerService.getByGender(gender);
            return new ResponseEntity(customerList,HttpStatus.FOUND);
        }
        catch(GenderException e){
            return new ResponseEntity(e.toString(),HttpStatus.BAD_REQUEST);
        }
    }
}
