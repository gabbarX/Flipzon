import java.util.ArrayList;
public class Deal {
    private ArrayList<Product> productsOnDeal = new ArrayList<Product>();
    private float dealPriceNormal;
    private float dealPricePrime;
    private float dealPriceElite;

    public Deal(Product fp , Product sp, float np, float ep, float pp) {
        this.productsOnDeal.add(fp);
        this.productsOnDeal.add(sp);
        this.dealPriceNormal=np;
        this.dealPriceElite=ep;
        this.dealPricePrime=pp;
    }
    public ArrayList<Product> getProductsOnDeal() {
        return productsOnDeal;
    }
    public float getDealPriceNormal() {
        return dealPriceNormal;
    }
    public float getDealPricePrime() {
        return dealPricePrime;
    }
    public float getDealPriceElite() {
        return dealPriceElite;
    }
}
