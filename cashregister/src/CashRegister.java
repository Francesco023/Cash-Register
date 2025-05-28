package cashregister.src;

import java.util.Iterator;

public class CashRegister {
    private CartItem[] items;
    private int itemCount;
    private final double TAX_RATE = 0.22;

    public CashRegister() {
        items = new CartItem[10];
        itemCount = 0;
    }

    private void ensureCapacity() {
        if (itemCount >= items.length) {
            CartItem[] newItems = new CartItem[items.length * 2];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
    }

    public void addItem(Product product, int quantity) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProduct().getName().equals(product.getName())) {
                items[i].increaseQuantity(quantity);
                return;
            }
        }
        ensureCapacity();
        items[itemCount++] = new CartItem(product, quantity);
    }

    public void removeItemByName(String productName) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProduct().getName().equalsIgnoreCase(productName)) {
                // sposta indietro tutti gli elementi successivi
                for (int j = i; j < itemCount - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[itemCount - 1] = null;
                itemCount--;
                break;
            }
        }
    }

    public double calculateSubtotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getSubtotal();
        }
        return total;
    }

    public double calculateTotalWithTax() {
        return calculateSubtotal() * (1 + TAX_RATE);
    }

    public int countTotalItems() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getQuantity();
        }
        return total;
    }

    public double averagePriceByCategory(String category) {
        double sum = 0.0;
        int count = 0;
        for (int i = 0; i < itemCount; i++) {
            Product p = items[i].getProduct();
            if (p.getCategory().equalsIgnoreCase(category)) {
                sum += p.getPrice();
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    public void applyDiscountToCategory(String category, double percent) {
        for (int i = 0; i < itemCount; i++) {
            Product p = items[i].getProduct();
            if (p.getCategory().equalsIgnoreCase(category)) {
                p.applyDiscount(percent);
            }
        }
    }

    public void printReceipt() {
        System.out.println("=== RECEIPT ===");
        for (int i = 0; i < itemCount; i++) {
            CartItem item = items[i];
            Product p = item.getProduct();
            System.out.printf("%s (%s) x%d = €%.2f%n",
                    p.getName(),
                    p.getCategory(),
                    item.getQuantity(),
                    item.getSubtotal()
            );
        }
        System.out.printf("Subtotal: €%.2f%n", calculateSubtotal());
        System.out.printf("Total with tax: €%.2f%n", calculateTotalWithTax());
        System.out.printf("Items: %d%n", countTotalItems());
        System.out.println("================");
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProduct().getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < itemCount; i++) {
            items[i] = null;
        }
        itemCount = 0;
    }
}
