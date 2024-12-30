package FoodDelivery.com.BYTES.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food_ItemResponse {

    int quantity;
    int price;
    String name;
}
