package cashregister.src;

public class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(String name, double price, String expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public String getCategory() {
        return "Food";
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
