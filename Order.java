import java.util.ArrayList;
import java.util.UUID;

public class Order {
    private ArrayList<Product> orderProducts;
    private ArrayList<Integer> orderProductsNumbers;
    private String id;
    private int totalCharge;

    //--------------------------------------------------------------------
    public Order() {
        this.id = UUID.randomUUID().toString();
    }

    //--------------------------------------------------------------------
    // copy current basket to arraylists in order
    // calcualte total money to be paid
    public void fillBasket(ArrayList<Product> basketProducts, ArrayList<Integer> basketProductsNumbers) {
        orderProducts = new ArrayList<>(basketProducts);
        orderProductsNumbers = new ArrayList<>(basketProductsNumbers);

        for (int i = 0; i < orderProducts.size(); i++) {
            totalCharge += orderProducts.get(i).getUnitPrice() * orderProductsNumbers.get(i);
        }
    }
    //--------------------------------------------------------------------
}