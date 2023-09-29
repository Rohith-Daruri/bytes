package FoodDelivery.com.BYTES.model;

import FoodDelivery.com.BYTES.Enum.Country;
import FoodDelivery.com.BYTES.Enum.Gender;
import FoodDelivery.com.BYTES.Enum.India;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(unique = true,nullable = false)
    String Email;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Enumerated(EnumType.STRING)
    Country country;
    @Enumerated(EnumType.STRING)
    India india;
    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<OrderEntity> orderEntityList = new ArrayList<>();



}
