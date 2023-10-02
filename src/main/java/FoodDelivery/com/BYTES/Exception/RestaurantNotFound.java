package FoodDelivery.com.BYTES.Exception;

public class RestaurantNotFound extends RuntimeException{
    public RestaurantNotFound(String message){
        super(message);
    }
}
