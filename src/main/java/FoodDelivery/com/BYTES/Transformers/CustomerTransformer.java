package FoodDelivery.com.BYTES.Transformers;

import FoodDelivery.com.BYTES.dto.request.CustomerRequest;
import FoodDelivery.com.BYTES.dto.response.CartResponse;
import FoodDelivery.com.BYTES.dto.response.CustomerResponse;
import FoodDelivery.com.BYTES.dto.response.FoodResponse;
import FoodDelivery.com.BYTES.model.Cart;
import FoodDelivery.com.BYTES.model.Customer;
import FoodDelivery.com.BYTES.model.Food_Item;

import java.util.ArrayList;
import java.util.List;

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
        List<Food_Item> foodItemList =customer.getCart().getFoodItemList();
        List<FoodResponse> foodResponse_List  =new ArrayList<>();
        if(foodItemList!=null) {
            for (Food_Item foodItem : foodItemList) {
                FoodResponse foodResponse = FoodResponse.builder()
                        .category(foodItem.getCategory())
                        .price(foodItem.getPrice())
                        .type(String.valueOf(foodItem.isVeg()))
                        .build();
                foodResponse_List.add(foodResponse);
            }
        }
        CartResponse cartResponse = CartResponse.builder()
                .cart_total(customer.getCart().getCart_total())
                .foodResponseList(foodResponse_List)
                .build();
        return CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .country(customer.getCountry())
                .cartResponse(cartResponse)
                .build();
    }
}
