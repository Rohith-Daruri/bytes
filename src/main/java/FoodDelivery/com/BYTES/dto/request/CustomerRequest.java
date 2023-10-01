package FoodDelivery.com.BYTES.dto.request;

import FoodDelivery.com.BYTES.Enum.Country;
import FoodDelivery.com.BYTES.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {
    String name;
    String email;
    Gender gender;
    Country country;
}
