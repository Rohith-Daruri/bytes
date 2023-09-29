package FoodDelivery.com.BYTES.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Order_ID;
    @CreationTimestamp
    Date date;

    @ManyToOne
    @JoinColumn
    Customer customer;
    @ManyToOne
    @JoinColumn
    Delivery_Partner delivery_partner;
    @ManyToOne
    @JoinColumn
    Restaurant restaurant;
    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    List<Food_Item> foodItemList =new ArrayList<>();
}
