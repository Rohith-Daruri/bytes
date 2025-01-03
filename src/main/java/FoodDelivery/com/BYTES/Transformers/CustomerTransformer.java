package FoodDelivery.com.BYTES.Transformers;

import FoodDelivery.com.BYTES.dto.request.CustomerRequest;
import FoodDelivery.com.BYTES.dto.response.CartResponse;
import FoodDelivery.com.BYTES.dto.response.CustomerResponse;
import FoodDelivery.com.BYTES.model.Customer;

public class CustomerTransformer {
    public static Customer RequestToModel(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .gender(customerRequest.getGender())
                .country(customerRequest.getCountry())
                .build();
    }
    public static CustomerResponse ModelToResponse(Customer customer){
        CartResponse cartResponse = CartTransformer.ModelToResponse(customer.getCart());
        return CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .country(customer.getCountry())
                .cartResponse(cartResponse)
                .build();
    }
}
