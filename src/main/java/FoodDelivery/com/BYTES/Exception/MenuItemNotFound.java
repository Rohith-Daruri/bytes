package FoodDelivery.com.BYTES.Exception;

public class MenuItemNotFound extends RuntimeException{
    public MenuItemNotFound(String message){
        super(message);
    }
}
