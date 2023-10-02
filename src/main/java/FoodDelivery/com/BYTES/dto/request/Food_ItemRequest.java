package FoodDelivery.com.BYTES.dto.request;

import FoodDelivery.com.BYTES.Enum.CATEGORY;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food_ItemRequest {
    String name;
    CATEGORY category;
    double price;
    boolean veg;
}
