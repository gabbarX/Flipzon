import java.util.ArrayList;
import java.util.Scanner;

interface adminInterface{
    void giveaway();
    void addCategory();
    void deleteCategory();
    void addProduct();
    void deleteProduct();
    void setDiscount();
}

public class Admin extends Account implements adminInterface{
    Scanner sc = new Scanner(System.in);
    private final String username;
    private final String password;

    public Admin(String name, String username, String password) {
        super(name, "Admin");
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public void addCategory(){

        System.out.println("You are currently adding category!");
        System.out.print("Enter the category ID: ");
        int catID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the name of the category : ");
        String catName = sc.nextLine();
        boolean flg = false;
        ArrayList<Category> catArr = Main.categories;
        for (Category category : catArr) {
            if (category.getID() == catID || category.getName().equals(catName)) {
                flg = true;
                break;
            }
        }
        if (flg) {
            System.out.println("Duplicate Category ID or Category Name exists. Please try again with unique name and ID.");
        } else {
            Main.categories.add(new Category(catID, catName));
            System.out.println("Category must not be empty! Please add a product");
            int target = 0;
            for (int i = 0; i < Main.categories.size(); i++) {
                if (Main.categories.get(i).getID() == catID) {
                    target = i;
                    break;
                }
            }
            System.out.print("Enter the Product ID: ");
            int pID = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the name of the product: ");
            String pname = sc.nextLine();
            System.out.print("Enter the price of the product: ");
            float pprice = sc.nextFloat();
            System.out.print("Enter the quantity of the product: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter other details for the product: ");
            String details = sc.nextLine();
            Main.categories.get(target).addProduct(pID, pname, pprice, details, quantity);
            System.out.println("Product added successfully!");
        }
    }
    @Override
    public void deleteCategory(){
        System.out.println("You are currently deleting a category.");
        System.out.print("Enter the category ID to delete: ");
        int catID = sc.nextInt();
        boolean flg = false;
        int target = 0;
        for (int i = 0; i < Main.categories.size(); i++) {
            if (Main.categories.get(i).getID() == catID) {
                target = i;
                flg = true;
                break;
            }
        }
        if (!flg) {
            System.out.println("Category does not exist. Nothing to delete.");
        } else {
            Main.categories.remove(target);
            System.out.println("Category successfully deleted.");
        }
    }
    @Override
    public void addProduct(){
        System.out.print("You are currently adding a product.");
        System.out.print("Enter the category ID for the product: ");
        int catID = sc.nextInt();
        sc.nextLine();
        boolean flg = false;
        int target = 0;
        for (int i = 0; i < Main.categories.size(); i++) {
            if (Main.categories.get(i).getID() == catID) {
                target = i;
                flg = true;
                break;
            }
        }
        if (!flg) {
            System.out.println("Category does not exist. Add category first.");
        } else {
            System.out.print("Enter the Product ID: ");
            int pID = sc.nextInt();
            boolean err=false;
            sc.nextLine();
            for(int i=0;i<Main.categories.get(target).getProducts().size();i++){
                if (pID == Main.categories.get(target).getProducts().get(i).getID()) {
//                    System.out.println("Err. Product ID must be unique.");
                    err = true;
                    break;
                }
            }
            if(err){
                System.out.println("Err. Product ID must be unique.");
            }
            else {
                System.out.print("Enter the name of the product: ");
                String pname = sc.nextLine();
                System.out.print("Enter the price of the product: ");
                float pprice = sc.nextFloat();
                System.out.print("Enter the quantity of the product: ");
                int quantity = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter other details for the product: ");
                String details = sc.nextLine();
                Main.categories.get(target).addProduct(pID, pname, pprice, details, quantity);
                System.out.println("Product added successfully!");
            }
        }
    }
    @Override
    public void setDiscount(){

        System.out.println("Dear Admin give the Product description you want to add discount for");
        System.out.print("Enter the product Category: ");
        int catID = sc.nextInt();
        boolean flg = false;
        int target = 0;
        for (int i = 0; i < Main.categories.size(); i++) {
            if (Main.categories.get(i).getID() == catID) {
                target = i;
                flg = true;
                break;
            }
        }
        if (!flg) {
            System.out.println("Category does not exist.");
        } else {
            System.out.print("Enter the product id: ");
            int pID = sc.nextInt();
            int ptarget = 0;
            ArrayList<Product> products = Main.categories.get(target).getProducts();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getID() == pID) {
                    ptarget = i;
                }
            }
            System.out.print("Enter the discount for elite members in % terms: ");
            float eDis = sc.nextFloat();
            System.out.print("Enter the discount for prime members in % terms: ");
            float pDis = sc.nextFloat();
            System.out.print("Enter the discount for normal members in % terms: ");
            float nDis = sc.nextFloat();
            products.get(ptarget).setEliteDiscount(eDis);
            products.get(ptarget).setNormalDiscount(nDis);
            products.get(ptarget).setPrimeDiscount(pDis);
            Main.categories.get(target).setProducts(products);
            System.out.println("Discount has been applied successfully!");
        }
    }

    @Override
    public void deleteProduct(){

        System.out.println("You are currently deleting a product.");
        System.out.print("Enter the category ID for the product to delete: ");
        int catID = sc.nextInt();
        boolean flg = false;
        int target = 0;
        for (int i = 0; i < Main.categories.size(); i++) {
            if (Main.categories.get(i).getID() == catID) {
                target = i;
                flg = true;
                break;
            }
        }
        if (!flg) {
            System.out.println("Category does not exist.");
        } else {
            System.out.print("Enter the product ID to delete: ");
            int pno = sc.nextInt();
            boolean pfound = false;
            int pTarget = 0;
            ArrayList<Product> products = Main.categories.get(target).getProducts();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getID() == pno) {
                    pfound = true;
                    pTarget = i;
                }
            }
            if (pfound) {
//                Main.categories.get(target).getProducts();
                Main.categories.get(target).deleteProduct(pTarget);
            } else {
                System.out.println("Product not found. Nothing to delete.");
            }
        }
    }
    @Override
    public void giveaway(){
        System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for:");
        System.out.print("Enter the first Product's Category ID: ");
        int FcatID = sc.nextInt();
        System.out.print("Enter the first Product's Product ID: ");
        int FproductID = sc.nextInt();
        Product fdealProduct = null;
        Product sdealProduct = null;
        float combPrice=0;
        for (int i = 0; i < Main.categories.size(); i++) {
            for (int j = 0; j < Main.categories.get(i).getProducts().size(); j++) {
                if (Main.categories.get(i).getID() == FcatID && Main.categories.get(i).getProducts().get(j).getID() == FproductID) {
                    fdealProduct = Main.categories.get(i).getProducts().get(j);
                    combPrice+=Main.categories.get(i).getProducts().get(j).getPrice();
                }
            }
        }
        System.out.print("Enter the second Product's Category ID: ");
        int ScatID = sc.nextInt();
        System.out.print("Enter the second Product's Product ID: ");
        int SproductID = sc.nextInt();
        for (int i = 0; i < Main.categories.size(); i++) {
            for (int j = 0; j < Main.categories.get(i).getProducts().size(); j++) {
                if (Main.categories.get(i).getID() == ScatID && Main.categories.get(i).getProducts().get(j).getID() == SproductID) {
                    sdealProduct = Main.categories.get(i).getProducts().get(j);
                    combPrice+=Main.categories.get(i).getProducts().get(j).getPrice();
                }
            }
        }
        System.out.println("Enter the Combined price for both the products in deal.");
        System.out.print("Price for Normal Users: ");
        float np = sc.nextFloat();
        System.out.println("Price for Prime Users: ");
        float pp = sc.nextFloat();
        System.out.println("Price for Elite Users: ");
        float ep = sc.nextFloat();
        if(combPrice<=np || combPrice<=pp || combPrice<=ep){
            System.out.println("Please enter a deal price which is less than the combined price of the items");
        }
        else {
            Main.deals.add(new Deal(fdealProduct, sdealProduct, np, ep, pp));
            System.out.println("Deal added successfully!");
        }
    }

}