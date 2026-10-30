package example.pizza;

/**
 * Klasa Dyrektora (Director) we wzorcu projektowym Budowniczy (Builder).
 * Odpowiada za definiowanie kolejności kroków budowy i tworzenie popularnych,
 * predefiniowanych wariantów pizzy (np. Margherita, Supreme, Pepperoni).
 *
 * Dzięki oparciu o wspólny interfejs PizzaBuilder, Dyrektor może współpracować z dowolnym
 * budowniczym: tworzącym obiekt domenowy (Pizza.Builder) lub generującym opis (PizzaMarketingBuilder).
 */
public class PizzaDirector {
    private PizzaBuilder builder;

    public PizzaDirector() {
    }

    public PizzaDirector(PizzaBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(PizzaBuilder builder) {
        this.builder = builder;
    }

    /**
     * Konfiguruje przekazanego budowniczego według receptury na pizzę Margherita.
     */
    public void constructMargherita(PizzaBuilder targetBuilder, Pizza.Size size) {
        targetBuilder.reset()
                .size(size)
                .cheese(2);
    }

    /**
     * Konfiguruje przekazanego budowniczego według receptury na pizzę Supreme.
     */
    public void constructSupreme(PizzaBuilder targetBuilder, Pizza.Size size) {
        targetBuilder.reset()
                .size(size)
                .cheese(2)
                .ham(1)
                .mushrooms(2)
                .olives(1)
                .pepperoni(2);
    }

    /**
     * Konfiguruje przekazanego budowniczego według receptury na pizzę Pepperoni.
     */
    public void constructPepperoni(PizzaBuilder targetBuilder, Pizza.Size size) {
        targetBuilder.reset()
                .size(size)
                .cheese(2)
                .pepperoni(3);
    }

    // --- Metody operujące na builderze zapisanym w instancji Directora ---

    public void constructMargherita(Pizza.Size size) {
        ensureBuilderSet();
        constructMargherita(this.builder, size);
    }

    public void constructSupreme(Pizza.Size size) {
        ensureBuilderSet();
        constructSupreme(this.builder, size);
    }

    public void constructPepperoni(Pizza.Size size) {
        ensureBuilderSet();
        constructPepperoni(this.builder, size);
    }

    // --- Wygodne metody pomocnicze do bezpośredniego tworzenia obiektów modelu Pizza ---

    public Pizza makeMargherita(Pizza.Size size) {
        Pizza.Builder b = new Pizza.Builder();
        constructMargherita(b, size);
        return b.build();
    }

    public Pizza makeSupreme(Pizza.Size size) {
        Pizza.Builder b = new Pizza.Builder();
        constructSupreme(b, size);
        return b.build();
    }

    public Pizza makePepperoni(Pizza.Size size) {
        Pizza.Builder b = new Pizza.Builder();
        constructPepperoni(b, size);
        return b.build();
    }

    private void ensureBuilderSet() {
        if (this.builder == null) {
            throw new IllegalStateException("Nie ustawiono instancji PizzaBuilder w PizzaDirector.");
        }
    }
}
