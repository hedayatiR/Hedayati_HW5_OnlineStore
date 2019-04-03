import java.util.ArrayList;

public class User {
    private ArrayList<Order> orders = new ArrayList<>();
    //--------------------------------------------------------------------
    // two arraylist for products and their corresponding numbers
    private ArrayList<Product> basketProducts = new ArrayList<>();
    private ArrayList<Integer> basketProductsNumbers = new ArrayList<>();
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String state;
    private String city;
    private String postalCode;
    private String address;

    //--------------------------------------------------------------------
    public String getPassword() {
        return password;
    }

    //--------------------------------------------------------------------
    public void setPassword(String password) {
        this.password = password;
    }

    //--------------------------------------------------------------------
    public ArrayList<Product> getBasketProducts() {
        return basketProducts;
    }

    //--------------------------------------------------------------------
    public ArrayList<Integer> getBasketProductsNumbers() {
        return basketProductsNumbers;
    }

    //--------------------------------------------------------------------
    public String getUserName() {
        return userName;
    }

    //--------------------------------------------------------------------
    public void setUserName(String userName) {
        this.userName = userName;
    }

    //--------------------------------------------------------------------
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //--------------------------------------------------------------------
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //--------------------------------------------------------------------
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //--------------------------------------------------------------------
    public void setEmail(String email) {
        this.email = email;
    }

    //--------------------------------------------------------------------
    public void setState(String state) {
        this.state = state;
    }

    //--------------------------------------------------------------------
    public void setCity(String city) {
        this.city = city;
    }

    //--------------------------------------------------------------------
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    //--------------------------------------------------------------------
    public void setAddress(String address) {
        this.address = address;
    }

    //--------------------------------------------------------------------
    public int numberOfProductsInBasket() {
        int totalNumbers = 0;
        for (Integer i : basketProductsNumbers) {
            totalNumbers += i;
        }
        return totalNumbers;
    }

    //--------------------------------------------------------------------
    public void addToBasket(Product prod, Integer number) {
        // check for upper limit number of product in a single order(5)
        if (numberOfProductsInBasket() + number > 5)
            System.out.println("Your basket exceeded the capacity(5). Please decrease number of products.\nthis item will not be added to basket!");

        else {
            basketProducts.add(prod);
            basketProductsNumbers.add(number);
            System.out.println("Product successfully added to basket.");
        }
    }

    //--------------------------------------------------------------------
    // this method is used when a product added to basket more than one time
    public void increaseNumberOfProduct(int index, int number) {
        basketProductsNumbers.set(index, (basketProductsNumbers.get(index) + number));
    }

    //--------------------------------------------------------------------
    public void removeFromBasket(int index) {
        basketProducts.remove(index);
        basketProductsNumbers.remove(index);
    }

    //--------------------------------------------------------------------
    public void showBasket() {

        if (basketProducts.size() == 0)
            System.out.println("Basket is empty!");
        else {
            for (int i = 0; i < basketProducts.size(); i++) {
                System.out.println("    " + (i + 1) + ". " + basketProducts.get(i).getName() + "  :  " + basketProductsNumbers.get(i));
            }
        }
    }

    //--------------------------------------------------------------------
    public void showPriceOfBasket() {
        int totalCharge = 0;

        for (int i = 0; i < basketProducts.size(); i++) {
            totalCharge += basketProducts.get(i).getUnitPrice() * basketProductsNumbers.get(i);
        }
        System.out.println("Total Charge of basket: " + totalCharge);
    }

    //--------------------------------------------------------------------
    // finalize current basket and register it.
    // clear current basket
    public void registerOrder() {
        Order registeredOrder = new Order();
        registeredOrder.fillBasket(basketProducts, basketProductsNumbers);
        orders.add(registeredOrder);
        basketProducts.clear();
        basketProductsNumbers.clear();
        System.out.println("Order has been successfully registered.");
    }
}
