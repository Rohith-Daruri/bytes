package FoodDelivery.com.BYTES.dto.response;

import FoodDelivery.com.BYTES.Enum.CATEGORY;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodResponse {
    CATEGORY category;
    double price;
    String type;
}
