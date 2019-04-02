import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Store {
    HashMap<String, Product> products = new HashMap<>();
    ArrayList<User> users = new ArrayList<>();
    //--------------------------------------------------------------------
    public void addUser() {
        System.out.println("You're going to make a new user.");
        // enter user name
        System.out.println("Enter your UserName: ");
        Scanner input = new Scanner(System.in);
        String userName;
        boolean userNameExisted = false;
        do {

            userName = input.next();
            userNameExisted = false;
            // check thst this userName is existed in database or not
            for (User user : users) {
                if (user.getUserName().equals(userName)) {
                    userNameExisted = true;
                    System.out.println("This user name is used before!");
                    System.out.println("Enter your new userName: ");
                    break;
                }
            }
        } while (userNameExisted);
        /////////////////////////////////////
        User newUser = new User();
        newUser.setUserName(userName);
        // enter password
        boolean passwordIncorrect = false;
        String password1;
        String password2;
        do {
            System.out.println("Enter your password: ");
            password1 = input.next();
            System.out.println("Reenter your password: ");
            password2 = input.next();
            passwordIncorrect = false;
            if (password1.equals(password2))
            {
                passwordIncorrect = true;
                System.out.println("Passwords doesn't match. Try again.");
            }
        }while (passwordIncorrect);
        /////////////////////////////////////
        newUser.setPassword(password1);

        // setFirstName
        System.out.println("Enter your first name: ");
        newUser.setFirstName(input.next());
        // setLastName
        System.out.println("Enter your last name: ");
        newUser.setLastName(input.next());
        // setPhoneNumber
        System.out.println("Enter your phone number: ");
        newUser.setPhoneNumber(input.next());
        // setState
        System.out.println("Enter your living state: ");
        newUser.setState(input.next());
        // setCity
        System.out.println("Enter your living city: ");
        newUser.setCity(input.next());
        // setPostalCode
        System.out.println("Enter your home postal code: ");
        newUser.setPostalCode(input.next());
        // setAddress
        System.out.println("Enter your complete address : ");
        newUser.setAddress(input.next());

        // add newUser to users ArrayList
        users.add(newUser);
    }
    //--------------------------------------------------------------------
    public void addProduct(String name, int unitPrice, int numbers, int category)
    {
        Product newProd = new Product();
        newProd.setName(name);
        newProd.setUnitPrice(unitPrice);
        newProd.setNumbersAvailable(numbers);
        newProd.setCategory(category);
        // add newProd to products ArrayList
        products.put(newProd.getId(), newProd);
    }
    //--------------------------------------------------------------------
    public void removeProduct(Product prod)
    {
        products.remove(prod.getId());
    }
    //--------------------------------------------------------------------
    public void showProducts()
    {
        System.out.println("List of available products :");
        for (Product prod : products.values()) {
            System.out.println(prod.getName() + "  :  " + prod.getNumbersAvailable());
        }
    }
    //--------------------------------------------------------------------
}