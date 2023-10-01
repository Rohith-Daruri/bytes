package FoodDelivery.com.BYTES.dto.response;

import FoodDelivery.com.BYTES.Enum.Country;
import FoodDelivery.com.BYTES.model.Cart;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {
    String name;
    String email;
    Country country;
    CartResponse cartResponse;
}
