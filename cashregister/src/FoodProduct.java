package cashregister.src;

/**
 * questa è una classe derivata dalla classe product e serve a mettere i prodotti di tipo cibo specificandone le data di scadenza e la categoria
 */
public class FoodProduct extends Product {
    private String expirationDate;

    /**
     * questo è il metodo costruttore che usa il super per prendere i parametri dalla classe padre
     * @param name nome del prodotto
     * @param price prezzo del prodotto
     * @param expirationDate data di scadenza del prodotto
     */
    public FoodProduct(String name, double price, String expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
    }

    /**
     * serve a ricavare la categoria
     * @return ritorna la categoria cibo
     */
    @Override
    public String getCategory() {
        return "Food";
    }

    /**
     * serve a ricavare la data di scadenza
     * @return ritorna la data di scadenza
     */
    public String getExpirationDate() {
        return expirationDate;
    }
}
