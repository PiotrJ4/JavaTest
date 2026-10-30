package example.pizza;

/**
 * Wspólny interfejs Budowniczego (Builder) w klasycznym wzorcu GoF.
 * Definiuje kroki konfiguracji pizzy, które mogą być realizowane przez różne implementacje:
 * - np. tworzącą obiekt modelu (Pizza.Builder)
 * - lub generującą tekst marketingowy/reklamowy (PizzaMarketingBuilder).
 */
public interface PizzaBuilder {
    PizzaBuilder reset();
    PizzaBuilder size(Pizza.Size size);
    PizzaBuilder cheese(int count);
    PizzaBuilder ham(int count);
    PizzaBuilder mushrooms(int count);
    PizzaBuilder olives(int count);
    PizzaBuilder pepperoni(int count);
}
