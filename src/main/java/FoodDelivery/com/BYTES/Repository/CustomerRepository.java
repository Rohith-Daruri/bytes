package FoodDelivery.com.BYTES.Repository;

import FoodDelivery.com.BYTES.Enum.Gender;
import FoodDelivery.com.BYTES.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
List<Customer> findByGender(Gender gender);
}
