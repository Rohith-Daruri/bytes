package FoodDelivery.com.BYTES.Repository;

import FoodDelivery.com.BYTES.model.Delivery_Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Delivery_PartnerRepository extends JpaRepository<Delivery_Partner,Integer> {

    String ans ="select p from Delivery_Partner p order by RAND() LIMIT 1";
    @Query(value = ans)
    Delivery_Partner findPartnerRandom();
}
