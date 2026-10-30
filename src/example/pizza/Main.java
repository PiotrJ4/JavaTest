package example.pizza;

public class Main {
    public static void main(String[] args) {
        PizzaDirector director = new PizzaDirector();

        System.out.println("==================================================");
        System.out.println("1. PIZZA.BUILDER -> TWORZENIE OBIEKTÓW MODELU");
        System.out.println("==================================================");

        // Używamy Directora do zbudowania obiektów domenowych Pizza:
        Pizza.Builder modelPizzaBuilder = new Pizza.Builder();

        director.constructMargherita(modelPizzaBuilder, Pizza.Size.SMALL);
        Pizza margherita = modelPizzaBuilder.build();

        director.constructSupreme(modelPizzaBuilder, Pizza.Size.LARGE);
        Pizza supreme = modelPizzaBuilder.build();

        System.out.println("Utworzone obiekty Pizza:");
        System.out.println("-> " + margherita);
        System.out.println("-> " + supreme);

        System.out.println("\n==================================================");
        System.out.println("2. PIZZAMARKETINGBUILDER -> OPISY REKLAMOWE (TEN SAM DIRECTOR)");
        System.out.println("==================================================");

        // Ten sam Director konfiguruje teraz PizzaMarketingBuilder:
        PizzaMarketingBuilder marketingBuilder = new PizzaMarketingBuilder();

        System.out.println("[Opis reklamowy Margherity przygotowany przez Directora]:");
        director.constructMargherita(marketingBuilder, Pizza.Size.SMALL);
        marketingBuilder.printDescription();

        System.out.println("\n[Opis reklamowy Supreme przygotowany przez Directora]:");
        director.constructSupreme(marketingBuilder, Pizza.Size.LARGE);
        marketingBuilder.printDescription();

        System.out.println("\n==================================================");
        System.out.println("3. AUTORSKA PIZZA (BEZPOŚREDNIO PRZEZ MARKETING BUILDER)");
        System.out.println("==================================================");
        PizzaMarketingBuilder customAd = new PizzaMarketingBuilder()
                .size(Pizza.Size.MEDIUM)
                .cheese(3)
                .pepperoni(2)
                .olives(1);
        customAd.printDescription();
    }
}
