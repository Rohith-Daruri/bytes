package FoodDelivery.com.BYTES.model;

import FoodDelivery.com.BYTES.Enum.RestaurantCategory;
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
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(unique = true,nullable = false)
    String mobile;
    @Column(unique = true,nullable = false)
    String email;
    @Enumerated(EnumType.STRING)
    RestaurantCategory restaurantCategory;
    boolean open;
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    List<Food_Item> foodItemList = new ArrayList<>();
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    List<OrderEntity>orderEntityList = new ArrayList<>();

    public boolean getOpen() {
        return open;
    }
}
