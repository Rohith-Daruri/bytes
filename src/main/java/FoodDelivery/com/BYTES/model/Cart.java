package FoodDelivery.com.BYTES.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    double cart_total;
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    List<Food_Item> foodItemList = new ArrayList<>();
    @OneToOne
    @JoinColumn
    Customer customer;
}
