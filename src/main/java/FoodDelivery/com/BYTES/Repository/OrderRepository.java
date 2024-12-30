package FoodDelivery.com.BYTES.Repository;

import FoodDelivery.com.BYTES.model.Delivery_Partner;
import FoodDelivery.com.BYTES.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

}
