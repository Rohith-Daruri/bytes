package FoodDelivery.com.BYTES.dto.response;

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
    List<Food_ItemResponse> foodResponseList;
}
