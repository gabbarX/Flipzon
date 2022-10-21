import java.util.ArrayList;
import java.util.Random;
import java.util.*;

interface customerInterface{
    float calculateDealCart();
    float calculateCartTotal();
    void printDealsInCart();
    void generateCoupons(int n);
}

public class customer extends Account implements customerInterface{
    Random rand = new Random();
    private ArrayList<Product> cart = new ArrayList<Product>();
    private ArrayList<Deal> Dealcart = new ArrayList<Deal>();
    private ArrayList<Integer> coupons = new ArrayList<Integer>();
    private float cartTotal=0;
    private String status="NORMAL";
    private String username;
    private String password;
    private float wallet=1000;
    customer(String name, String username, String password) {
        super(name, "Customer");
        this.username = username;
        this.password = password;
    }

    public ArrayList<Deal> getDealcart() {
        return Dealcart;
    }
    @Override
    public float calculateDealCart(){
        float dealCartTotal= 0;
        for (Deal deal : Dealcart) {
            if (this.status.equals("ELITE")) {
                dealCartTotal += deal.getDealPriceElite();
            } else if (this.status.equals("PRIME")) {
                dealCartTotal += deal.getDealPricePrime();
            } else if (this.status.equals("NORMAL")) {
                dealCartTotal += deal.getDealPriceNormal();
            }
        }
        return dealCartTotal;
    }
    //POLYMORPHISM
    float maxDiscount(float f1, float f2){
        return Math.max(f1, f2);
    }
    float maxDiscount(float f1,float f2,float f3){
        float temp = Math.max(f1,f2);
        return Math.max(temp,f3);
    }
    @Override
    public float calculateCartTotal(){
        for (Product product : cart) {
            if (this.status.equals("ELITE")) {
                if (!coupons.isEmpty()) {
                    float maxDiscount = maxDiscount(coupons.get(0), product.getEliteDiscount(), 10);
                    this.cartTotal = cartTotal + (product.getPrice() - product.getPrice() * (maxDiscount / 100));
                }
                else {
                    float maxDiscount = maxDiscount(product.getEliteDiscount(), 10);
                    this.cartTotal = cartTotal + (product.getPrice() - product.getPrice() * (maxDiscount / 100));
                }
            } else if (this.status.equals("PRIME")) {
                if (!coupons.isEmpty()) {
                    float maxDiscount = maxDiscount(coupons.get(0), product.getPrimeDiscount(), 5);
                    this.cartTotal = cartTotal + (product.getPrice() - product.getPrice() * (maxDiscount / 100));
                }
                else {
                    float maxDiscount = maxDiscount(product.getPrimeDiscount(), 5);
                    this.cartTotal = cartTotal + (product.getPrice() - product.getPrice() * (maxDiscount / 100));
                }
            } else {
                float maxDiscount = maxDiscount(product.getNormalDiscount(), 0);
                this.cartTotal = cartTotal + (product.getPrice() - product.getPrice() * (maxDiscount / 100));

            }
            if (!Dealcart.isEmpty()) {
                this.cartTotal += calculateDealCart();
            }
        }
        return cartTotal;
    }
    @Override
    public void printDealsInCart(){
        for(Deal deal :Dealcart){
            ArrayList<Product> products = deal.getProductsOnDeal();
            for(Product product: products){
                System.out.print(product.getName()+" ");
            }
            System.out.print("Deal Price: ");
            if(this.status.equals("ELITE")){
                System.out.println(deal.getDealPriceElite());
            }
            else if(this.status.equals("NORMAL")){
                System.out.println(deal.getDealPriceNormal());
            }
            else if(this.status.equals("PRIME")){
                System.out.println(deal.getDealPricePrime());
            }
        }
    }
    @Override
    public void generateCoupons(int n){
        for(int i=0;i<n;i++){
            int temp = rand.nextInt(5,16);
            coupons.add(temp);
        }
        coupons.sort(Collections.reverseOrder());
    }

    public ArrayList<Integer> getCoupons() {
        return coupons;
    }

    public String getUsername() {
        return username;
    }

    public void paid(float amount) {
        this.wallet = this.wallet-amount;
    }

    public String getStatus() {
        return status;
    }

    public void addMoney(float amount) {
        this.wallet = this.wallet + amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }
    public void addDealToCart(Deal item){
        this.Dealcart.add(item);
    }
    public void addToCart(Product item){
        this.cart.add(item);
    }

    public float getCartTotal() {
        return cartTotal;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public float getWallet() {
        return wallet;
    }


    public String getName(){
        return super.getName();
    }

    public String getPassword() {
        return password;
    }

    public void checkout(){

    }
}
