package FoodDelivery.com.BYTES.model;

import FoodDelivery.com.BYTES.Enum.Gender;
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
public class Delivery_Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(unique = true,nullable = false)
    String phone_no;
    int age;
    @Enumerated(EnumType.STRING)
    Gender gender;
    String vehicle_no;
    @OneToMany(mappedBy = "delivery_partner",cascade = CascadeType.ALL)
    List<OrderEntity> orderEntityList =new ArrayList<>();

}
