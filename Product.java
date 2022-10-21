public class Product {
    private int ID;
    private String name;
    private float price;
    private int initialQuantity=0;
    private int quantity=0;
    private float eliteDiscount=0;
    private float primeDiscount=0;
    private float normalDiscount=0;
    private String details;
    private boolean exists = true;

    public Product(int ID, String name, float price, String details, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.details=details;
        this.quantity = quantity;
    }
    public void setEliteDiscount(float eliteDiscount) {
        this.eliteDiscount = eliteDiscount;
    }

    public void resetQuantity(){
        this.quantity = this.initialQuantity;
    }
    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public float getEliteDiscount() {
        return eliteDiscount;
    }

    public float getPrimeDiscount() {
        return primeDiscount;
    }

    public float getNormalDiscount() {
        return normalDiscount;
    }

    public String getDetails() {
        return details;
    }

    public void setPrimeDiscount(float primeDiscount) {
        this.primeDiscount = primeDiscount;
    }
    public void setNormalDiscount(float normalDiscount) {
        this.normalDiscount = normalDiscount;
    }
    public int getID() {
        return ID;
    }
}
