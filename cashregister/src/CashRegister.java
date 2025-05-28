package cashregister.src;

import java.util.Iterator;

/**
 * questa è la classe usata per la cassa avendo un array di oggetti per i prodotti aggiunti
 * con item count per contare quanti prodotti si hanno
 * e una costante per le tasse
 */

public class CashRegister {
    private CartItem[] items;
    private int itemCount;
    private final double TAX_RATE = 0.22;

    /**
     * metodo costruttore con array inizializzato a valore 10 e itemcount a 0
     */
    public CashRegister() {
        items = new CartItem[10];
        itemCount = 0;
    }

    /**
     * serve ad assicurarsi della capacità del carrello con il comando if che dice se il contatore di prodotti è inferiore a i prodotti che si hanno si aggiungono al carrello
     */
    private void ensureCapacity() {
        if (itemCount >= items.length) {
            CartItem[] newItems = new CartItem[items.length * 2];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
    }

    /**
     * questo metodo serve ad aggiungere i prodotti al carrello
     * @param product sono i prodotti
     * @param quantity è la quantità di prodotti che si vogliono prendere di uno stesso prodotto
     */

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

    /**
     * questo metodo serve a rimuovere prodotti che non si vogliono più
     * @param productName il nome del prodotto da rimuovere
     */
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

    /**
     * serve a calcolare il totale di prodotti
     * @return ritorna il valore del totale
     */

    public double calculateSubtotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getSubtotal();
        }
        return total;
    }

    /**
     * serve a calcolare il prezzo con la tassa
     * @return
     */
    public double calculateTotalWithTax() {
        return calculateSubtotal() * (1 + TAX_RATE);
    }

    /**
     * conta i prodotti che si hanno
     * @return ritorna il totale di prodotti
     */
    public int countTotalItems() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getQuantity();
        }
        return total;
    }

    /**
     * serve a calcolare il prezzo generale per categoria
     * @param category parametro per la categoria che si vuole calcolare il prezzo generale
     * @return ritorna il conto
     */
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

    /**
     * serve ad applicare lo sconto
     * @param category la categoria da applicare lo sconto
     * @param percent la percentuale dello sconto
     */
    public void applyDiscountToCategory(String category, double percent) {
        for (int i = 0; i < itemCount; i++) {
            Product p = items[i].getProduct();
            if (p.getCategory().equalsIgnoreCase(category)) {
                p.applyDiscount(percent);
            }
        }
    }

    /**
     * metodo per stampare lo scontrino
     */
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

    /**
     * metodo booleano per vedere quale prodotto contiene
     * @param productName nome del prodotto
     * @return ritorna vero se la condizione if è vera
     */
    public boolean containsProduct(String productName) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProduct().getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * serve a rimuovere tutti i prodotti dal carrello
     */

    public void clear() {
        for (int i = 0; i < itemCount; i++) {
            items[i] = null;
        }
        itemCount = 0;
    }
}
