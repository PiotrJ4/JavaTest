package example.pizza;

public class Main {
    public static void main(String[] args) {
        Pizza margherita = new Pizza.Builder()
                .size(Pizza.Size.SMALL)
                .cheese(2)
                .build();

        Pizza supreme = new Pizza.Builder()
                .size(Pizza.Size.LARGE)
                .cheese(2)
                .ham(1)
                .mushrooms(2)
                .olives(1)
                .pepperoni(2)
                .build();

        System.out.println(margherita);
        System.out.println(supreme);
    }
}
