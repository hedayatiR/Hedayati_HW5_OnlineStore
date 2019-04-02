import java.util.UUID;

public class Product {
    private String id;
    private int category;
    private String name;
    private int unitPrice;
    private int numbersAvailable;
    private String descriptions;
    //--------------------------------------------------------------------
    public Product()
    {
        this.id = UUID.randomUUID().toString();
    }
    //--------------------------------------------------------------------
    public int getNumbersAvailable() {
        return numbersAvailable;
    }
    //--------------------------------------------------------------------
    public void setNumbersAvailable(int numbersAvailable) {
        this.numbersAvailable = numbersAvailable;
    }

    //--------------------------------------------------------------------
    public String getId() {
        return id;
    }

    //--------------------------------------------------------------------
    public void setCategory(int category) {
        this.category = category;
    }

    //--------------------------------------------------------------------
    public String getName() {
        return name;
    }
    //--------------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }
    //--------------------------------------------------------------------
    public int getUnitPrice() {
        return unitPrice;
    }
    //--------------------------------------------------------------------
    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    //--------------------------------------------------------------------
}
