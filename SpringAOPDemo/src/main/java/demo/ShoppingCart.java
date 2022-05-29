package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout(String status){
        // Logging
        // Auth
        // Sanitize data
        System.out.println("Checkout method from shopping cart Called");
    }

    public int quantity(){
        return 2;
    }
}
