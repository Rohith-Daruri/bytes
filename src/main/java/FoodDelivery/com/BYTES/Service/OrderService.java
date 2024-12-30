package FoodDelivery.com.BYTES.Service;

import FoodDelivery.com.BYTES.Exception.CartEmptyException;
import FoodDelivery.com.BYTES.Exception.CustomerNotFoundException;
import FoodDelivery.com.BYTES.Repository.*;
import FoodDelivery.com.BYTES.Transformers.OrderTransformer;
import FoodDelivery.com.BYTES.dto.response.OrderResponse;
import FoodDelivery.com.BYTES.model.*;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    Delivery_PartnerRepository deliveryPartnerRepository;
    @Autowired
    FoodRepository foodRepository;
    public OrderResponse add_Order(int customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        if(customer==null){
            throw new CustomerNotFoundException("Customer Not found!!!");
        }
        Cart cart = customer.getCart();
        if(cart.getFoodItemList().size()==0){
            throw new CartEmptyException("Cart Empty!!! Add food to Cart before ordering");
        }
        OrderEntity order = new OrderEntity();
        order.setOrder_ID(String.valueOf(UUID.randomUUID()));
        order.setTotal(cart.getCart_total());
        order.setCustomer(customer);
        Delivery_Partner deliveryPartner = deliveryPartnerRepository.findPartnerRandom();
        order.setDelivery_partner(deliveryPartner);
        Restaurant restaurant = cart.getFoodItemList().get(0).getMenuItem().getRestaurant();
        order.setRestaurant(restaurant);
        order.setFoodItemList(cart.getFoodItemList());
        OrderEntity orderEntity = orderRepository.save(order);
        restaurant.getOrderEntityList().add(orderEntity);
        for(Food_Item foodItem:cart.getFoodItemList()){
            foodItem.setCart(null);
            foodItem.setOrderEntity(orderEntity);
        }
        clear_cart(cart);
        List<Food_Item> foodItemList = foodRepository.findAll();
        for(Food_Item foodItem:foodItemList){
            if(foodItem.getCart().getId()== cart.getId()){
                foodItemList.remove(foodItem);
            }
        }
        customerRepository.save(customer);
        deliveryPartnerRepository.save(deliveryPartner);
        restaurantRepository.save(restaurant);
        return OrderTransformer.ModelToResponse(orderEntity);
    }

    public void clear_cart(Cart cart) {
        cart.setCart_total(0);
        cart.setFoodItemList(new ArrayList<>());
    }
}
