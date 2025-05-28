package cashregister.src;


/**
 * @author Alberto Spaziano
 * @since 28/05/2025
 */
public class Main {


    public static void main(String[] args) {

        /**
         * CashRegister è il metodo costruttore usato nella classe cashregister per creare un nuovo oggetto
         */
        CashRegister register = new CashRegister();

        /**
         * Qui vengono creati 3 oggetti che inizializzano 3 prodotti differenti
         */

        Product bread = new FoodProduct("Bread", 1.5, "2025-01-01");
        Product milk = new FoodProduct("Milk", 1.2, "2025-01-10");
        Product tv = new ElectronicProduct("TV", 450.00, 36);

        /**
         * qui vengono aggiunti 3 prodotti specificandone la quantità
         */

        register.addItem(bread, 2);
        register.addItem(milk, 3);
        register.addItem(tv, 1);

        /**
         * mentre register.applyDiscountToCategory("Food", 10); ha la funzione di applicare uno sconto del 10%
         */

        register.applyDiscountToCategory("Food", 10);

        /**
         * mentre la funzione register.printRecipt() serve a stampare lo scontrino
         */

        register.printReceipt();

        /**
         * qui vengono stampati i risultati.
         */
        System.out.printf("Prezzo medio elettronica: €%.2f ",
            register.averagePriceByCategory("Electronics")
        );

        register.removeItemByName("Milk");
        System.out.println(" Dopo rimozione latte:");
        register.printReceipt();
    }
}
