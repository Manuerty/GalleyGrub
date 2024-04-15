package edu.badpals.galleyGrub;

import edu.badpals.galleyGrub.items.Prices;
import edu.badpals.galleyGrub.items.Product;
import edu.badpals.galleyGrub.items.Item;
import edu.badpals.galleyGrub.order.Command;
import edu.badpals.galleyGrub.order.Order;
import edu.badpals.galleyGrub.receipt.Receipt;
import edu.badpals.galleyGrub.receipt.Ticket;
import edu.badpals.galleyGrub.extras.Extra;
import edu.badpals.galleyGrub.extras.Regular;
import edu.badpals.galleyGrub.extras.CheeseExtra;
import edu.badpals.galleyGrub.extras.SauceExtra;
import edu.badpals.galleyGrub.extras.SizeLargeExtra;


public class App
{
    public static void main( String[] args )
    {

        /**
         * Crea un diccionario con los precios
         * de los extras.
         *
         *  Los precios de los extras son estos:
         *  - cheese +0.25
         *  - sauce +0.50
         *  - medium +0.25
         *  - large +0.50
         *
         * Lee los precios de los items en la imagen
         * del menu proporcionada.
         */

        Prices.initPrices();

        // formatea la salida de cada entrada del diccionario como prefieras
        System.out.print("\n\t --- PRICES ---  \n");
        Prices.display();

        /**
         * Crea los items del menu
         * y printa sus datos.
         *
         * Krabby Patty
         * Coral Bits
         * Kelp Rings
         * Golden Loaf
         * Seafoam Soda
         *
         * Incluye los metodos sobrescritos
         * equals y hascode para comparar objetos
         * de tipo Item.
         */

        System.out.print("\n\t --- GALLEY GRUB ---  \n");

        Product patty = new Item("Krabby Patty", 1.25);
        display(patty);
        Product bits = new Item("Coral Bits", 1.00);
        display(bits);
        Product rings = new Item("Kelp Rings", 1.50);
        display(rings);
        Product loaf = new Item("Golden Loaf", 2.00);
        display(loaf);
        Product soda = new Item("Seafoam Soda", 1.00);
        display(soda);

        /**
         * Bubble Bass llega al restaurante
         * y hace una comanda muy simple.
         * Quiere todo lo que hay en el menu
         * en su tamaño estandar y sin
         * condimentos extras.
         *
         * Squidward Tentacles crea la comanda
         * y la muestra en la pantalla para que
         * el cliente le de el visto bueno
         * antes de generar el recibo con la factura.
         *
         *
         * OPCIONAL:
         * Puesto que a lo largo del dia van a generarse muchos objetos
         * siempre del mismo tipo, vamos a ahorrar memoria.
         *
         * Implementa la clase ItemFactory siguiendo los casos test
         * que se proporcionan.
         *
         * ItemFactory crea el Item que le pides,
         * lo guarda en un diccionario y lo devuelve.
         * Cuando solicitas crear de nuevo ese Item
         * te devuelve la misma referencia al objeto que has creado antes,
         * ahorrando asi memoria.
         */

        Command order = new Order();

        order.addItem("Krabby Patty", 1.25);
        order.addItem("Coral Bits", 1.00);
        order.addItem("Kelp Rings", 1.50);
        order.addItem("Golden Loaf", 2.00);
        order.addItem("Seafoam Soda", 1.00);

        order.display();

        /**
         * Squidward Tentacles genera el recibo,
         * la app calcula el importe total de la comanda
         * y lo muestra en pantalla.
         */

        Ticket receipt = new Receipt(order);
        receipt.total();
        receipt.print();

        /**
         * Eugene H. Krabs quiere obtener un margen
         * de beneficio extra y decide cargar
         * por los extras.
         *
         * Modifica el tipo Item para incluir los extras.
         *
         * Refactoriza el metodo toString() de Item
         * para mostrar el ingrediente extra.
         *
         * NO ACTUALICES EL PRECIO DEL ITEM
         * con el cargo extra
         * pues eso lo haremos con otro componente.
         */

        System.out.print("\n\t --- GALLEY GRUB ---  \n");

        patty = new Item("Krabby Patty", 1.25, "cheese");
        display(patty);
        bits = new Item("Coral Bits", 1.00, "medium");
        display(bits);
        rings = new Item("Kelp Rings", 1.50, "sauce");
        display(rings);
        loaf = new Item("Golden Loaf", 2.00, "sauce");
        display(loaf);
        soda = new Item("Seafoam Soda", 1.00, "large");
        display(soda);
        /**
         * Buble Fish sigue zampando
         * y realiza una comanda cargada
         * de extras.
         */

        order = new Order();

        order.addItem("Krabby Patty", 1.25, "cheese");
        order.addItem("Coral Bits", 1.00);
        order.addItem("Kelp Rings", 1.50, "sauce");
        order.addItem("Golden Loaf", 2.00, "sauce");
        order.addItem("Seafoam Soda", 1.00, "large");
        order.addItem("Coral Bits", 1.00, "large");

        // Utiliza el diccionario Prices para incluir
        // el precio de los extras en la salida por consola.
        order.display();


        /**
         * Define el importe a cargar por cada extra.
         *
         * Configura los tipos de Extras:
         *  - extra Cheese +0.25
         *  - extra sauce +0.50
         *  - size medium +0.25
         *  - size large +0.50
         *
         * Sigue los casos test del paquete Extras
         * para implementar 4 clases que se encargan
         * de sumar el precio base de los Items
         * y de los extras para calcular el precio
         * total de Order (la comanda).
         *
         * El precio total de la comanda se guarda en Order.
         */

        Extra regular = new Regular(); // suma el precio base
        Extra cheese = new CheeseExtra(); // suma el precio del extra cheese
        Extra sauce = new SauceExtra(); // suma el precio de sauce
        Extra size = new SizeLargeExtra(); // suma el precio del tamanho Large

        regular.setNextExtra(cheese);
        cheese.setNextExtra(sauce);
        sauce.setNextExtra(size);
        /**
         * Squidward Tentacles genera el recibo,
         * la app calcula el importe total de la comanda
         * y lo muestra en pantalla.
         */

        System.out.print("\n\t --- PRINTIG RECEIPT BIPBIPBIP ---  \n");

        Ticket receiptExtra = new Receipt(order);
        receiptExtra.setChain(regular);

        receiptExtra.total();
        receiptExtra.print();

    }

    public static void display(Product item) {
        System.out.print("\t" + item.toString() + "\n");
    }
}