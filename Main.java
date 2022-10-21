import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static ArrayList<Category> categories = new ArrayList<Category>();
    static ArrayList<Deal> deals = new ArrayList<Deal>();
    private static ArrayList<customer> customers = new ArrayList<customer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Admin admin = new Admin("Ankit", "ankit21518","hehe123");

        while (true) {

            System.out.println("Welcome to FLIPZON!");
            System.out.println("1. Enter as admin.");
            System.out.println("2. Explore the product catalog.");
            System.out.println("3. Show available Deals.");
            System.out.println("4. Enter as Customer.");
            System.out.println("5. Exit.");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("You are currently attempting to enter into Admin mode");
                    System.out.print("Enter your username: ");
                    String adminUserName = sc.nextLine();
                    System.out.print("Enter your password: ");
                    String adminUserPass = sc.nextLine();
                    if (adminUserName.equals(admin.getUsername()) && adminUserPass.equals(admin.getPassword())) {
                        System.out.println("Login successful. You are now an admin");
                        {
                            boolean adminMenu = true;
                            while (adminMenu) {

                                System.out.println("Please choose any one of the following actions.");
                                System.out.println("1. Add category.");
                                System.out.println("2. Delete category.");
                                System.out.println("3. Add product.");
                                System.out.println("4. Delete product.");
                                System.out.println("5. Set Discount on product.");
                                System.out.println("6. Add giveaway deal.");
                                System.out.println("7. Back.");
                                int Achoice = sc.nextInt();
                                switch (Achoice) {
                                    case 1 -> {
                                        admin.addCategory();
                                    }
                                    case 2 -> {
                                        admin.deleteCategory();
                                    }
                                    case 3 -> {
                                        admin.addProduct();
                                    }
                                    case 4 -> {
                                        admin.deleteProduct();
                                    }
                                    case 5 -> {
                                        admin.setDiscount();
                                    }
                                    case 6 -> {
                                        admin.giveaway();
                                    }
                                    case 7 -> {
                                        adminMenu = false;
                                    }
                                    default -> {
                                        System.out.println("Please enter a valid choice!");
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Incorrect login attempt.");
                        System.out.println();
                    }
                }
                case 2 -> {
                    if (categories.isEmpty()) {
                        System.out.println("There are no products available for now! Please comeback later!");
                    } else {
                        for (Category category : categories) {
                            System.out.println("CATEGORY: " + category.getName());
                            ArrayList<Product> products = category.getProducts();
                            for (Product product : products) {
                                System.out.println(product.getID() + " >> " + product.getName());
                                System.out.println("Price : " + product.getPrice());
                                System.out.println("Qty: "+product.getQuantity());
                                System.out.println("Details : " + product.getDetails());
                            }
                        }
                    }
                }
                case 3 -> {
                    if (deals.isEmpty()) {
                        System.out.println("There are currently no deals available!");
                    } else {
                        int count = 1;
                        for (Deal deal : deals) {
                            System.out.println("Deal " + count + ":");
                            count++;
                            ArrayList<Product> products = deal.getProductsOnDeal();
                            for (Product product : products) {
                                System.out.print(product.getName() + " ");
                                System.out.println("Price for Normal users: " + deal.getDealPriceNormal());
                                System.out.println("Price for Elite users: " + deal.getDealPriceElite());
                                System.out.println("Price for prime users: " + deal.getDealPricePrime());
                            }

                        }
                    }
                }
                case 4 -> {
                    boolean customerMenu=true;
                    while (customerMenu) {
                        System.out.println("Welcome to the Customer mode!");
                        System.out.println("Select from the below available options:");
                        System.out.println("1. Sign up");
                        System.out.println("2. Log in");
                        System.out.println("3. Back");
                        int ch = sc.nextInt();
                        sc.nextLine();
                        switch (ch) {
                            case 1 -> {
                                System.out.print("Enter your name: ");
                                String name = sc.nextLine();
                                System.out.print("Enter your username: ");
                                String userName = sc.nextLine();
                                System.out.print("Enter your password: ");
                                String password = sc.nextLine();
                                customers.add(new customer(name, userName, password));
                                System.out.println("You have successfully registered for FLIPZON.");
                                System.out.println();
                                break;
                            }
                            case 2 -> {
                                System.out.print("Enter your username: ");
                                String username = sc.nextLine();
                                System.out.print("Enter your password: ");
                                String password = sc.nextLine();
                                boolean isLogged = false;
                                int target = 0;
                                for (int i = 0; i < customers.size(); i++) {
                                    if (customers.get(i).getUsername().equals(username) && customers.get(i).getPassword().equals(password)) {
                                        isLogged = true;
                                        target = i;
                                        break;
                                    }
                                }
                                if(!isLogged){
                                    System.out.println("Errr. Wrong username or password!");
                                }
                                    while (isLogged){
                                    System.out.println("Welcome " + customers.get(target).getName() + " !!!");
                                    System.out.println("1. Browse products.");
                                    System.out.println("2. Browse deals.");
                                    System.out.println("3. Add a product to the cart.");
                                    System.out.println("4. Add product in deal to the cart.");
                                    System.out.println("5. view coupons.");
                                    System.out.println("6. check account balance.");
                                    System.out.println("7. view cart.");
                                    System.out.println("8. empty cart.");
                                    System.out.println("9. checkout cart.");
                                    System.out.println("10. upgrade customer status.");
                                    System.out.println("11. Add amount to wallet");
                                    System.out.println("12. Back");
                                    int customerChoice = sc.nextInt();
                                    switch (customerChoice) {
                                        case 1 -> {
                                            if(categories.isEmpty()){
                                                System.out.println("There are currently no products to browse!");
                                            }
                                            else {
                                                System.out.println("Product catalog!");
                                                for (int i = 0; i < categories.size(); i++) {
                                                    System.out.println("CATEGORY: " + categories.get(i).getName());
                                                    ArrayList<Product> products = categories.get(i).getProducts();
                                                    for (Product product : products) {
                                                        System.out.println(product.getID() + " >> " + product.getName());
                                                        System.out.println("Price : " + products.get(i).getPrice());
                                                        System.out.println("Qty: "+products.get(i).getQuantity());
                                                        System.out.println("Details : " + products.get(i).getDetails());
                                                    }
                                                }
                                            }
                                        }
                                        case 2 -> {
                                            if(deals.isEmpty()){
                                                System.out.println("There are currently no deals");
                                            }
                                            else {
                                                System.out.println("Yay deals!");
                                                for (int i = 0; i < deals.size(); i++) {
                                                    System.out.println("Deal " + (i + 1) + ": ");
                                                    ArrayList<Product> products = new ArrayList<Product>();
                                                    float np = deals.get(i).getDealPriceNormal();
                                                    float pp = deals.get(i).getDealPricePrime();
                                                    float ep = deals.get(i).getDealPriceElite();
                                                    products = deals.get(i).getProductsOnDeal();
                                                    for (int j = 0; j < products.size(); j++) {
                                                        System.out.println((j + 1) + ". " + products.get(j).getName());
                                                    }
                                                    System.out.println("Elite Price: " + ep);
                                                    System.out.println("Prime Price: " + pp);
                                                    System.out.println("Normal Price: " + np);
                                                }
                                            }
                                        }
                                        case 3 -> {
                                            System.out.print("Enter the category ID for the product: ");
                                            int cID = sc.nextInt();
                                            System.out.print("Enter the product ID to add in the cart: ");
                                            int pID = sc.nextInt();
                                            System.out.print("Enter the quantity of the product to add in the cart: ");
                                            int quantity = sc.nextInt();
                                            int targetCat = 0;
                                            int targetProd = 0;
                                            for (int i = 0; i < categories.size(); i++) {
                                                if (categories.get(i).getID() == cID) {
                                                    targetCat = i;
                                                    break;
                                                }
                                            }
                                            ArrayList<Product> products = categories.get(targetCat).getProducts();
                                            for (int i = 0; i < products.size(); i++) {
                                                if (products.get(i).getID() == pID) {
                                                    targetProd = i;
                                                    break;
                                                }
                                            }
                                            if (products.get(targetProd).getQuantity() < quantity) {
                                                System.out.println("You cannot buy more than the available quantity.");
                                            } else {
                                                customers.get(target).addToCart(products.get(targetProd));
                                                products.get(targetProd).setInitialQuantity(products.get(targetProd).getQuantity());
                                                products.get(targetProd).setQuantity(products.get(targetProd).getQuantity() - quantity);
                                                System.out.println("Product added to the cart successfully!");
                                            }
                                        }
                                        case 4 -> {
                                            System.out.print("Enter the deal number to add in the cart: ");
                                            int dealNumber = sc.nextInt();
                                            for (int i = 0; i < deals.size(); i++) {
                                                customers.get(target).addDealToCart((deals.get(dealNumber-1)));
                                            }
                                        }
                                        case 5 -> {
                                            if(customers.get(target).getCoupons().isEmpty()){
                                                System.out.println("No coupons for you :(");
                                            }
                                            else {
                                                System.out.println("You have following coupons available to you:");
                                                ArrayList<Integer> coupons;
                                                coupons = customers.get(target).getCoupons();
                                                for (int i = 0; i < coupons.size(); i++) {
                                                    System.out.println((i + 1) + ". " + coupons.get(i));
                                                }
                                            }
                                        }
                                        case 6 -> {
                                            System.out.println("Your current balance is: " + customers.get(target).getWallet());
                                        }
                                        case 7 -> {
                                            ArrayList<Product> cart;
                                            cart = customers.get(target).getCart();
                                            if (cart.isEmpty() && customers.get(target).getDealcart().isEmpty()) {
                                                System.out.println("Your Cart is empty!");
                                            } else {
                                                System.out.println("<--------YOUR CART-------->");
                                                for (int i = 0; i < cart.size(); i++) {
                                                    System.out.println(i + 1 + ". Product: " + cart.get(i).getName() + "  --->   price: " + cart.get(i).getPrice());
                                                }
                                                if (!deals.isEmpty()) {
                                                    System.out.println("<------DEALS IN CART------->");
                                                    customers.get(target).printDealsInCart();
                                                }
                                            }
                                        }
                                        case 8 -> {
                                            if (customers.get(target).getCart().size() == 0) {
                                                System.out.println("The cart is already empty!");
                                            } else {
                                                ArrayList<Product> emptyCart = new ArrayList<Product>();
                                                customers.get(target).setCart(emptyCart);
                                                //resetting quantities for all products
                                                for (Category category : categories) {
                                                    ArrayList<Product> products = category.getProducts();
                                                    for (Product product : products) {
                                                        product.resetQuantity();
                                                    }
                                                }
                                                System.out.println("The cart has been successfully emptied!");
                                            }
                                        }
                                        case 9 -> {
                                            float kindaTotal = customers.get(target).calculateCartTotal();
                                            float deliveryCharge = 0;
                                            System.out.println("Proceeding to checkout!");
                                            System.out.println("Details:");
                                            System.out.println("<--------YOUR CART-------->");
                                            ArrayList<Product> cart;
                                            cart = customers.get(target).getCart();
                                            for (int i = 0; i < cart.size(); i++) {
                                                System.out.println(i + 1 + ". Product: " + cart.get(i).getName() + "  --->   price: " + cart.get(i).getPrice());
                                            }
                                            switch (customers.get(target).getStatus()) {
                                                case "NORMAL" -> {
                                                    deliveryCharge = 100 + (float) 0.05 * kindaTotal;
                                                    System.out.println("Delivery charges: Rs " + 100 + " + 5% of " + kindaTotal + " = 100 + " + (float) 0.05 * kindaTotal + " = Rs. " + deliveryCharge);
                                                    float total = deliveryCharge + kindaTotal;
                                                    System.out.println("Total Cost: " + total);
                                                    if (total > customers.get(target).getWallet()) {
                                                        System.out.println("Insufficient Funds in your wallet!");
                                                    } else {
                                                        System.out.println("Your order will be delivered within 10 days.");
                                                        customers.get(target).paid(total);
                                                    }
                                                }
                                                case "PRIME" -> {
                                                    deliveryCharge = 100 + (float) 0.02 * kindaTotal;
                                                    System.out.println("Delivery charges: Rs " + 100 + " + 2% of " + kindaTotal + " = 100 + " + (float) 0.02 * kindaTotal + " = Rs. " + deliveryCharge);
                                                    float total = deliveryCharge + kindaTotal;
                                                    System.out.println("Total Cost: " + total);
                                                    if (total > customers.get(target).getWallet()) {
                                                        System.out.println("Insufficient Funds in your wallet!");
                                                    } else {
                                                        System.out.println("Your order will be delivered within 3 days.");
                                                        customers.get(target).paid(total);
                                                        if (total > 5000) {
                                                            customers.get(target).generateCoupons(2);
                                                        }
                                                    }
                                                }
                                                case "ELITE" -> {
                                                    deliveryCharge = 100;
                                                    float total = deliveryCharge + kindaTotal;
                                                    System.out.println("Delivery charges: Rs. 100");
                                                    System.out.println("Total Cost: Rs. " + total);
                                                    if (total > customers.get(target).getWallet()) {
                                                        System.out.println("Insufficient Funds in your wallet!");
                                                    } else {
                                                        System.out.println("Your order will be delivered within 2 days");
                                                        if (total > 5000) {
                                                            int rand1= rand.nextInt(categories.size());
                                                            int rand2= rand.nextInt(categories.get(rand1).getProducts().size());
                                                            System.out.println("Congratulations! You have received 1 unit of "+categories.get(rand1).getProducts().get(rand2).getName()+" for being an ELITE customer.");
                                                            customers.get(target).generateCoupons(4);
                                                            System.out.println("You have also received 4 discount coupons. Which have been added to your account.");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        case 10 -> {
                                            sc.nextLine();
                                            System.out.println("Your current status is: " + customers.get(target).getStatus());
                                            System.out.print("Choose new status: ");
                                            String newStatus = sc.nextLine();
                                            if (Objects.equals(newStatus, "PRIME")) {
                                                if (customers.get(target).getWallet() >= 200) {
                                                    customers.get(target).paid(200);
                                                    customers.get(target).setStatus("PRIME");
                                                } else {
                                                    System.out.println("Insufficient funds.");
                                                }
                                            } else if (Objects.equals(newStatus, "ELITE")) {
                                                if (customers.get(target).getWallet() >= 300) {
                                                    customers.get(target).paid(300);
                                                    customers.get(target).setStatus("ELITE");
                                                } else {
                                                    System.out.println("Insufficient funds.");
                                                }
                                            }
                                        }
                                        case 11 -> {
                                            System.out.println("Add amount to wallet");
                                            System.out.print("Your current wallet balance is " + customers.get(target).getWallet());
                                            System.out.print("Enter the amount to add in wallet: ");
                                            float amount = sc.nextFloat();
                                            customers.get(target).addMoney(amount);
                                            System.out.println("Amount added successfully!");
                                        }
                                        case 12 -> {
                                            isLogged=false;
                                        }
                                        default -> {
                                            System.out.println("Invalid choice.");
                                        }
                                    }
                                }
                            }
                            case 3 ->{
                                customerMenu=false;
                            }
                        }
                    }
                }
                case 5 -> {
                    return;
                }
                default -> {
                    System.out.println("Please enter a valid choice");
                }
            }
        }

    }
}