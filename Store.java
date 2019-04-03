import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    ArrayList<Product> products = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    private User loggedInUser; //current User logged in

    //--------------------------------------------------------------------
    public User getLoggedInUser() {
        return loggedInUser;
    }

    //--------------------------------------------------------------------
    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    //--------------------------------------------------------------------
    // define a new user
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
            if (!password1.equals(password2)) {
                passwordIncorrect = true;
                System.out.println("Passwords doesn't match. Try again.");
            }
        } while (passwordIncorrect);
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
        // setEmail
        System.out.println("Enter your email: ");
        newUser.setEmail(input.next());
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
        loggedInUser = newUser;
    }
    //--------------------------------------------------------------------
    // login with defined users
    public void login() {
        Scanner input = new Scanner(System.in);
        boolean invalidInput;
        boolean match = false;

        do {
            invalidInput = false;
            System.out.println();
            System.out.println("Select one of the actions below:");
            System.out.println("1. Login.");
            System.out.println("2. Create new user.");

            int menuCursor = input.nextInt();
            switch (menuCursor) {
                case 1:
                    match = this.checkUserPass();
                    break;
                case 2:
                    this.addUser();
                    break;
                default:
                    invalidInput = true;
                    System.out.println("Enter a valid number.");
            }

        } while (invalidInput || !match);

    }
    //--------------------------------------------------------------------
    public boolean checkUserPass()
    {
        boolean match = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username:");
        String userName = input.next();
        System.out.println("Enter your password:");
        String password = input.next();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserName().equals(userName))
            {
                if(users.get(i).getPassword().equals(password))
                {
                    loggedInUser =  users.get(i);
                    System.out.println("You logged in successfully as " + loggedInUser.getUserName());
                    match = true;
                }
                break;
            }
        }
        if (!match)
            System.out.println("Username or password doesn't match!");
        return match;
    }
    //--------------------------------------------------------------------
    public void addProduct(String name, int unitPrice, int numbers, int category) {
        Product newProd = new Product();
        newProd.setName(name);
        newProd.setUnitPrice(unitPrice);
        newProd.setNumbersAvailable(numbers);
        newProd.setCategory(category);
        products.add(newProd);
    }

    //--------------------------------------------------------------------
    public void removeProduct(int index) {
        products.remove(index);
    }

    //--------------------------------------------------------------------
    public void showProducts() {
        System.out.println("List of available products :");
        for (int i = 0; i < products.size(); i++) {
            System.out.println("    " + (i + 1) + ". " + products.get(i).getName() + " : " + products.get(i).getNumbersAvailable());
        }
    }

    //--------------------------------------------------------------------
    public void addToUserBasketUi() {
        Scanner input = new Scanner(System.in);
        System.out.println("Which of the following products you want to add to your basket:");
        this.showProducts();
        System.out.println("Enter index of it:");
        int index = input.nextInt();
        System.out.println("Enter number of this product you want:");
        int number = input.nextInt();

        if (products.get(index - 1).getNumbersAvailable() < number)
            System.out.println("there is just " + products.get(index - 1).getNumbersAvailable() + " numbers available! Your basket will be like before.");
        else
            checkForAvailabilityEditBasket(index, number);

        System.out.println();
    }

    //--------------------------------------------------------------------
    public void checkForAvailabilityEditBasket(int index, int number) {
        boolean existInList = false;
        for (int i = 0; i < loggedInUser.getBasketProducts().size(); i++) {
            if (loggedInUser.getBasketProducts().get(i).getId().equals(products.get(index - 1).getId())) {
                if (loggedInUser.getBasketProductsNumbers().get(i) + number > products.get(index - 1).getNumbersAvailable()) {
                    System.out.println("there is just " + products.get(index - 1).getNumbersAvailable() + " numbers available! Your basket will be like before.");
                } else {
                    loggedInUser.increaseNumberOfProduct(i, number);
                    System.out.println("Product successfully added to basket.");
                }

                existInList = true;
                break;
            }
        }
        if (!existInList) {
            loggedInUser.addToBasket(products.get(index - 1), number);
            System.out.println("Product successfully added to basket.");
        }
    }

    //--------------------------------------------------------------------
    public void removeFromUserBasketUi() {
        Scanner input = new Scanner(System.in);
        System.out.println("Which of the following products you want to remove from your basket:");
        loggedInUser.showBasket();
        System.out.println("Enter index of it:");
        int index = input.nextInt();
        System.out.println();
        loggedInUser.removeFromBasket(index - 1);
    }

    //--------------------------------------------------------------------
    public void updateProductsNumbersAvailable() {
        for (int i = 0; i < loggedInUser.getBasketProducts().size(); i++) {
            for (int j = 0; j < products.size(); j++) {
                if (loggedInUser.getBasketProducts().get(i).getId().equals(products.get(j).getId())) {
                    products.get(j).setNumbersAvailable(products.get(j).getNumbersAvailable() - loggedInUser.getBasketProductsNumbers().get(i));
                    break;
                }

            }
        }

    }
    //--------------------------------------------------------------------
}