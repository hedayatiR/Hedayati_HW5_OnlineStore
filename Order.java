import java.util.HashMap;
import java.util.UUID;

public class Order {
    HashMap<Product, Integer> basketPurchased = new HashMap<>();
    private String id;
    private int totalCharge;
    //--------------------------------------------------------------------
    public Order()
    {
         this.id = UUID.randomUUID().toString();
    }
    //--------------------------------------------------------------------
    public void fillBasket(HashMap<Product, Integer> basket)
    {
        basketPurchased = basket;
        for (Product prod : basketPurchased.keySet()) {
            totalCharge += prod.getUnitPrice() *  basketPurchased.get(prod);
        }
    }
    //--------------------------------------------------------------------
}
