import java.util.ArrayList;

public class Category {
    private ArrayList<Product> products = new ArrayList<Product>();
    private String name;
    private int ID;
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public void addProduct(int pID, String pname, float pprice, String details,int quantity){
        products.add(new Product(pID,pname,pprice,details,quantity));
    }
    public void deleteProduct(int target){
        if(products.size()==1){
            System.out.println("You cannot delete this product because the category cannot be left empty.");
            System.out.println("Try deleting the entire category or add another product to continue deleting this item.");
        }
        else {
            products.remove(target);
        }
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }

    public Category(int ID, String name) {
        this.name = name;
        this.ID = ID;
    }
}
