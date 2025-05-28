package cashregister.src;

/**
 * classe per il carrello con attributi privati che specificano il prodotto e la quantita
 */
public class CartItem {
    private Product product;
    private int quantity;

    /**
     * metodo costruttore
     * @param product prodotto nel carrello
     * @param quantity quantita del prodotto
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * totale del prezzo
     * @return ritorna il prezzo calcolato
     */
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    /**
     * metodo per ricavare il prodotto da mettere nel carrello
     * @return il prodotto
     */
    public Product getProduct() {
        return product;
    }

    /**
     * metodo per ricavare la quantità
     * @return ritorna la quantita
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * incrementa la quantita se si vuole più di uno stesso prodotto
     * @param amount parametro che determina il valore di quanto si vuole incrementare
     */
    public void increaseQuantity(int amount) {
        if (amount > 0) {
            quantity += amount;
        }
    }

    /**
     * metodo per diminuire la quantita
     * @param amount valore di quanto di vuole diminuire la quantita
     */
    public void decreaseQuantity(int amount) {
        if (amount > 0 && quantity - amount > 0) {
            quantity -= amount;
        }
    }
}
