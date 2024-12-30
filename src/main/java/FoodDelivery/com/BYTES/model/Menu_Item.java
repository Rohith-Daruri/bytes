package FoodDelivery.com.BYTES.model;

import FoodDelivery.com.BYTES.Enum.CATEGORY;
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
public class Menu_Item {
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
    Restaurant restaurant;
    @OneToMany(mappedBy = "menuItem",cascade = CascadeType.ALL)
    List<Food_Item>foodItemList = new ArrayList<>();

    public boolean getAvailable() {
        return available;
    }
}
