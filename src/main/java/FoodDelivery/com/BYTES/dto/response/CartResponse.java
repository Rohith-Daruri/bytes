package FoodDelivery.com.BYTES.dto.response;

import FoodDelivery.com.BYTES.model.Cart;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartResponse {
    int cart_total;
    List<FoodResponse> foodResponseList;
}
