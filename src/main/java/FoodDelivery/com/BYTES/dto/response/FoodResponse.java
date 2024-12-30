package FoodDelivery.com.BYTES.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodResponse {
    int CustomerId;
    String CustomerEmail;
    String RestaurantName;
    double Price;
}
