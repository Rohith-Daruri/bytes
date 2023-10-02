package FoodDelivery.com.BYTES.dto.response;

import FoodDelivery.com.BYTES.Enum.RestaurantCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RestaurantResponse {
     String name;
     String mobile;
     String email;
     RestaurantCategory restaurantCategory;
     List<FoodResponse>menu;

}
