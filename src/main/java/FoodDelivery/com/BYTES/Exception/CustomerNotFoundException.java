package FoodDelivery.com.BYTES.Exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException (String message){
        super(message);
    }
}
