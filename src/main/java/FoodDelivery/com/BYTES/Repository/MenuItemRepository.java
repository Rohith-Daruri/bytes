package FoodDelivery.com.BYTES.Repository;

import FoodDelivery.com.BYTES.model.Menu_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<Menu_Item,Integer> {
}
