package FoodDelivery.com.BYTES.dto.request;

import FoodDelivery.com.BYTES.Enum.RestaurantCategory;
import FoodDelivery.com.BYTES.model.Restaurant;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RestaurantRequest {

     String name;
     String mobile;
     String email;
    RestaurantCategory restaurantCategory;

}
