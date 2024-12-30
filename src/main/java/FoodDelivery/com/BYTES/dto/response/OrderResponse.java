package FoodDelivery.com.BYTES.dto.response;

import FoodDelivery.com.BYTES.model.Food_Item;
import FoodDelivery.com.BYTES.model.Restaurant;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    double orderTotal;
    Restaurant restaurant;
    List<Food_Item> foodItem;

}
