package cashregister.src;

/**
 * Qui viene creata una classe astratta con attributi name e price protetti.
 */
public abstract class Product {
    protected String name;
    protected double price;

    /**
     * il metodo product serve ad inizializzare i seguenti parametri per i prodotti
     * @param name è la variabile della classe astratta che poi viene usato this per fare il riferimento
     * @param price è la variabile della classe astratta che poi viene usato this per fare il riferimento
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * il metodo astratto viene usato per ricavare la categoria del prodotto
     */
    public abstract String getCategory();

    /**
     * il seguente metodo getName serve a ricavare il nome precedentemente istanziato come protetto
     * @return ritorna il nome
     */
    public String getName() {
        return name;
    }

    /**
     * il seguente metodo viene usato per settare il nome
     * @param newName serve a impostare un nome nuovo
     */
    public void setName(String newName) {
        /**
         * questo comando dice che quando new name non è null e non è vuoto allora deve aggiungere il nome con il comando appuntato this riferendosi al nome
         */
        if (newName != null && !newName.trim().isEmpty()) {
            this.name = newName;
        }
    }

    /**
     * il metodo getprice serve a tornare il prezzo impostato a protected
     * @return ritorna il prezzo
     */

    public double getPrice() {
        return price;
    }

    /**
     * questo metodo serve a inserire un nuovo prezzo
     * @param newPrice serve a impostare il nuovo prezzo nella variabile
     */

    public void setPrice(double newPrice) {

        /**
         * il seguente comando dice che se il nuovo prezzo è minore uguale a 0 allora deve impostare un nuovo prezzo attraverso il comando appuntato this
         */
        if (newPrice >= 0) {
            this.price = newPrice;
        }
    }

    /**
     * questo metodo serve ad applicare lo sconto
     * @param percentage è il parametro passato per la percentuale
     */
    public void applyDiscount(double percentage) {
        /**
         * il comando if dice che se la percentuale è maggiore di zero e minore di centro, di fare il calcolo del prezzo
         */
        if (percentage > 0 && percentage <= 100) {
            price = price - (price * percentage / 100.0);
        }
    }

    /**
     * questo metodo booleano serve a controllare se il prodotto è lo stesso
     * @param other è usato nell'if per controllare se è null
     * @return ritorna il nome quando il nome è uguale a ignore case e la stessa cosa per la categoria
     */

    public boolean isSameProduct(Product other) {
        if (other == null) return false;
        return this.name.equalsIgnoreCase(other.name)
                && this.getCategory().equalsIgnoreCase(other.getCategory());
    }

    /**
     * formatta i caratteri
     * @return ritorna la stringa formattata
     */
    public String getFormattedLabel() {
        return String.format("%s - %s: €%.2f", getCategory(), name, price);
    }

    /**
     * questo metodo booleano serve a controllare se il prodotto è troppo costoso
     * @param threshold è il limite del prezzo prima che sia troppo costoso
     * @return ritorna il prezzo se è maggiore di threshold.
     */
    public boolean isExpensive(double threshold) {
        return price > threshold;
    }

}
