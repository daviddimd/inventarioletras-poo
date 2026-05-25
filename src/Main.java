public class Main {
    public static void main(String[] args) {
        InventarioLetras inv = new InventarioLetras("Hola Mundo");

        System.out.println("size: " + inv.size());
        System.out.println("isEmpty: " + inv.isEmpty());
        System.out.println("get('o'): " + inv.get('o'));
        System.out.println(inv);

        System.out.println(inv.encriptarCesar('a'));
        System.out.println(inv.encriptarPalabra("play", 3));

        InventarioLetras inv1 = new InventarioLetras("Alan Turing");
        InventarioLetras inv2 = new InventarioLetras("Ada Lovelace");
        InventarioLetras suma = inv1.add(inv2);
        System.out.println("Suma: " + suma);
    }
}