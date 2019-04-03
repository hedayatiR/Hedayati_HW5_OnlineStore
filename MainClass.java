import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Store onlineStore = new Store();
        onlineStore.addProduct("Dell Laptop", 2000, 4, 1);
        onlineStore.addProduct("Samsung J5 phone", 300, 12, 1);
        onlineStore.addProduct("Adidas sport shoe", 200, 24, 2);
        onlineStore.addProduct("Shima Formal shoe", 100, 20, 2);
        onlineStore.addProduct("How to stop worrying and start living Book", 10, 10, 3);
        onlineStore.addProduct("Effective Java Book", 5, 5, 3);
        onlineStore.addProduct("Java How to Program Book", 7, 7, 3);

        System.out.println("You must sign up at first!");
        onlineStore.addUser();
        int menuCursor = 0;
        boolean invalidInput;
        while (true) {
            // does some user logged in?
            // if not Enter user name and password
            if (onlineStore.getLoggedInUser() == null) {
                System.out.println("You are not logged in. Please log in!");
                onlineStore.login();
            } else {
                invalidInput = false;
                do {
                    System.out.println();
                    System.out.println("Select one of the actions below:");
                    System.out.println("1. Show products of store.");
                    System.out.println("2. Show my basket products.");
                    System.out.println("3. Add product to my basket.");
                    System.out.println("4. Remove product from my basket.");
                    System.out.println("5. Show total charge of my basket.");
                    System.out.println("6. register my order.");
                    System.out.println("7. Logout.");
                    menuCursor = input.nextInt();
                    switch (menuCursor) {
                        case 1:
                            onlineStore.showProducts();
                            break;
                        case 2:
                            onlineStore.getLoggedInUser().showBasket();
                            break;
                        case 3:
                            onlineStore.addToUserBasketUi();
                            break;
                        case 4:
                            onlineStore.removeFromUserBasketUi();
                            break;
                        case 5:
                            onlineStore.getLoggedInUser().showPriceOfBasket();
                            break;
                        case 6:
                            onlineStore.updateProductsNumbersAvailable();
                            onlineStore.getLoggedInUser().registerOrder();
                            break;
                        case 7:
                            onlineStore.setLoggedInUser(null);
                            break;
                        default:
                            invalidInput = true;
                            System.out.println("Enter a valid number.");
                    }

                } while (invalidInput);
            }
        }
    }

}

