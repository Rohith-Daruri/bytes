package FoodDelivery.com.BYTES.Service;

import FoodDelivery.com.BYTES.Enum.Gender;
import FoodDelivery.com.BYTES.Repository.CustomerRepository;
import FoodDelivery.com.BYTES.dto.response.CustomerResponse;
import FoodDelivery.com.BYTES.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    public void getByGenderTest() {
        Gender gender = Gender.MALE;
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Rohith");
        List<Customer> customerList = Arrays.asList(customer);
        Mockito.when(customerRepository.findByGender(gender)).thenReturn(customerList);
        List<CustomerResponse> customers = customerService.getByGender(gender);
        Assertions.assertEquals(customers.get(0).getName(),customer.getName());
        Mockito.verify(customerRepository,Mockito.times(1)).findByGender(gender);
    }

    //This is the actual implementation to use the mocked concept here mockito-inline is required.
    @Test
    public void mockFinalMethod() {
        int value = customerService.print(10,20);
        int value1 = customerService.print(30,40);
        System.out.println(value);
        System.out.println(value1);
        Assertions.assertEquals(30,value);
    }
}

