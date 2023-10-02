package FoodDelivery.com.BYTES.Transformers;

import FoodDelivery.com.BYTES.dto.response.CartResponse;
import FoodDelivery.com.BYTES.model.Cart;

import java.util.ArrayList;

public class CartTransformer {
    public static CartResponse ModelToResponse(Cart cart){
        return CartResponse.builder()
                .cart_total(0)
                .foodResponseList(new ArrayList<>())
                .build();
    }
}
