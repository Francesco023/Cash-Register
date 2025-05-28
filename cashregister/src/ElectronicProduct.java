package cashregister.src;

public class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String name, double price, int warrantyMonths) {
        super(name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}
