package cashregister.src;

/**
 * questa è una classe derivata per i prodotti elettronici specificandone anche i mesi di garanzia
 */

public class ElectronicProduct extends Product {
    private int warrantyMonths;

    /**
     * questo è il metodo costruttore, usa anche il comando super per prendere i parametri della classe padre
     * @param name nome del prodotto
     * @param price prezzo del prodotto
     * @param warrantyMonths mesi di garanzia
     */
    public ElectronicProduct(String name, double price, int warrantyMonths) {
        super(name, price);
        this.warrantyMonths = warrantyMonths;
    }

    /**
     * metodo per ricavare la categoria
     * @return ritorna la categoria "Electronics"
     */
    @Override
    public String getCategory() {
        return "Electronics";
    }

    /**
     * ricava i mesi per la garanzia
     * @return ritorna i mesi della garanzia
     */
    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}
