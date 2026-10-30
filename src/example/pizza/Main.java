package example.pizza;

public class Main {
    public static void main(String[] args) {
        // 1. Bezpośrednie użycie Buildera (pizze customowe):
        Pizza customPizza = new Pizza.Builder()
                .size(Pizza.Size.MEDIUM)
                .cheese(3)
                .olives(1)
                .build();
        System.out.println("Pizza zrobiona bezpośrednio przez Builder: " + customPizza);

        // 2. Użycie Dyrektora (Director) do przygotowania gotowych receptur:
        PizzaDirector director = new PizzaDirector();

        Pizza margherita = director.makeMargherita(Pizza.Size.SMALL);
        Pizza supreme = director.makeSupreme(Pizza.Size.LARGE);
        Pizza pepperoni = director.makePepperoni(Pizza.Size.MEDIUM);

        System.out.println("\nPizze przygotowane przez Dyrektora (PizzaDirector):");
        System.out.println("Margherita: " + margherita);
        System.out.println("Supreme:    " + supreme);
        System.out.println("Pepperoni:  " + pepperoni);
    }
}
