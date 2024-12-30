package FoodDelivery.com.BYTES.Service;

import FoodDelivery.com.BYTES.Exception.CartEmptyException;
import FoodDelivery.com.BYTES.Exception.CustomerNotFoundException;
import FoodDelivery.com.BYTES.Exception.MenuItemNotFound;
import FoodDelivery.com.BYTES.Repository.CartRepository;
import FoodDelivery.com.BYTES.Repository.CustomerRepository;
import FoodDelivery.com.BYTES.Repository.FoodRepository;
import FoodDelivery.com.BYTES.Repository.MenuItemRepository;
import FoodDelivery.com.BYTES.Transformers.FoodTransformer;
import FoodDelivery.com.BYTES.dto.request.FoodRequest;
import FoodDelivery.com.BYTES.dto.response.FoodResponse;
import FoodDelivery.com.BYTES.model.*;
import FoodDelivery.com.BYTES.utils.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;

@Service
public class CartService {
    @Autowired
    Validation validation;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MenuItemRepository menuItemRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    FoodRepository foodRepository;

    public FoodResponse addFoodToCart(FoodRequest foodRequest,int CustomerId,int MenuId) {
        boolean customerValue = validation.CustomerValidation(CustomerId);
        if(!customerValue){
            throw new CustomerNotFoundException("Customer Not Found!!!");
        }
        Cart cart =  customerRepository.findById(CustomerId).get().getCart();

        boolean menuValue = validation.MenuValidation(MenuId);
        if(!menuValue){
            throw new MenuItemNotFound("Selected Item not Found");
        }
        if(cart.getFoodItemList().size()>0){
            Restaurant restaurant = cart.getFoodItemList().get(0).getMenuItem().getRestaurant();
            if(!restaurant.getName().equals(menuItemRepository.findById(MenuId).get().getRestaurant().getName())){
                throw new CartEmptyException("Cart is full");
            }
        }
        Food_Item foodItem = FoodTransformer.RequestToModel(foodRequest);
        foodItem.setCart(cart);
        Menu_Item menuItem = menuItemRepository.findById(MenuId).get();
        foodItem.setMenuItem(menuItem);
        double price = foodRequest.getQuantity() * menuItem.getPrice();
        foodItem.setPrice(price);
        Food_Item savedFood = foodRepository.save(foodItem);
        cart.getFoodItemList().add(savedFood);
        Cart savedCart = cartRepository.save(cart);
        menuItem.getFoodItemList().add(savedFood);
        Menu_Item savedMenuItem = menuItemRepository.save(menuItem);
        double cart_total  =0;
        for(Food_Item food: savedCart.getFoodItemList()){
            cart_total += food.getPrice();
        }
        savedCart.setCart_total(cart_total);
        cartRepository.save(savedCart);
        FoodResponse foodResponse = FoodTransformer.ModelToResponse(savedFood);
        return foodResponse;
    }

    public void clear(int customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.getCart().setCart_total(0);
        customer.getCart().setFoodItemList(new ArrayList<>());
    }
}
