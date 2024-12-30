package FoodDelivery.com.BYTES.Repository;

import FoodDelivery.com.BYTES.model.Food_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food_Item,Integer> {
}
