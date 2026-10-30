package example.pizza;

public class Main {
    public static void main(String[] args) {
        Pizza margherita = new Pizza(2, 0, 0, 0, 0, Pizza.Size.SMALL);
        Pizza supreme = new Pizza(2, 1, 2, 1, 2, Pizza.Size.LARGE);

        System.out.println(margherita);
        System.out.println(supreme);
    }
}
