package FoodDelivery.com.BYTES.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery_Partner_Response {
    String name;
    String vehicleNo;
}
