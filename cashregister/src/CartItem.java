package cashregister.src;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        if (amount > 0) {
            quantity += amount;
        }
    }

    public void decreaseQuantity(int amount) {
        if (amount > 0 && quantity - amount > 0) {
            quantity -= amount;
        }
    }
}
