package FoodDelivery.com.BYTES.dto.request;

import FoodDelivery.com.BYTES.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery_PartnerRequest {
    String name;
    String phone_no;
    int age;
    Gender gender;
    String vehicle_no;
}
