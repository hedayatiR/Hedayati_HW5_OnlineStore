import java.util.HashMap;

public class User {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emsil;
    private String state;
    private String city;
    private String postalCode;
    private String address;
    //--------------------------------------------------------------------
    HashMap<Product, Integer> basket = new HashMap<Product, Integer>();
    //--------------------------------------------------------------------
    public void addToBasket(Product prod, Integer number)
    {
        basket.put(prod, number);
    }
    //--------------------------------------------------------------------
    public void removeFromBasket(Product prod)
    {
        basket.remove(prod);
    }
    //--------------------------------------------------------------------
    public void showBasket()
    {
        for (Product prod : basket.keySet()) {
            System.out.println(prod.getName() + "  :  " + basket.get(prod));
        }
    }
    //--------------------------------------------------------------------
    public void showPriceOfBasket()
    {
        int totalCharge = 0;
        for (Product prod : basket.keySet()) {
            totalCharge += prod.getUnitPrice() *  basket.get(prod);
        }
        System.out.println("Total Charge of basket: "  + totalCharge);
    }
    //--------------------------------------------------------------------
}
