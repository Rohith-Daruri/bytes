package FoodDelivery.com.BYTES.Transformers;

import FoodDelivery.com.BYTES.dto.response.OrderResponse;
import FoodDelivery.com.BYTES.model.OrderEntity;

public class OrderTransformer {
    public static OrderResponse ModelToResponse(OrderEntity order){
        return OrderResponse.builder()
                .orderTotal(order.getTotal())
                .restaurant(order.getRestaurant())
                .foodItem(order.getFoodItemList())
                .build();
    }
}
