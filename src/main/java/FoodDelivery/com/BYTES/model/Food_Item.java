package FoodDelivery.com.BYTES.model;

import FoodDelivery.com.BYTES.Enum.CATEGORY;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Food_Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Enumerated(EnumType.STRING)
    CATEGORY category;
    double price;
    boolean available;
    boolean veg;
    @ManyToOne
    @JoinColumn
    Cart cart;
    @ManyToOne
    @JoinColumn
    OrderEntity orderEntity;
    @ManyToOne
    @JoinColumn
    Restaurant restaurant;
}
