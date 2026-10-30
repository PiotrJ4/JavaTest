package example.pizza;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    @DisplayName("Powinno poprawnie utworzyć pizzę margherita za pomocą Buildera")
    void shouldBuildMargheritaPizza() {
        Pizza pizza = new Pizza.Builder()
                .size(Pizza.Size.SMALL)
                .cheese(2)
                .build();

        assertNotNull(pizza);
        assertEquals(Pizza.Size.SMALL, pizza.getSize());
        assertEquals(2, pizza.getCheese());
        assertEquals(0, pizza.getHam());
        assertEquals(0, pizza.getMushrooms());
        assertEquals(0, pizza.getOlives());
        assertEquals(0, pizza.getPepperoni());
    }

    @Test
    @DisplayName("Powinno poprawnie utworzyć pizzę supreme ze wszystkimi składnikami")
    void shouldBuildSupremePizza() {
        Pizza pizza = new Pizza.Builder(Pizza.Size.LARGE)
                .cheese(2)
                .ham(1)
                .mushrooms(2)
                .olives(1)
                .pepperoni(2)
                .build();

        assertEquals(Pizza.Size.LARGE, pizza.getSize());
        assertEquals(2, pizza.getCheese());
        assertEquals(1, pizza.getHam());
        assertEquals(2, pizza.getMushrooms());
        assertEquals(1, pizza.getOlives());
        assertEquals(2, pizza.getPepperoni());
    }

    @Test
    @DisplayName("Powinno rzucić wyjątek, gdy rozmiar nie został ustawiony")
    void shouldThrowExceptionWhenSizeIsNull() {
        Pizza.Builder builder = new Pizza.Builder().cheese(1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, builder::build);
        assertEquals("Rozmiar pizzy nie może być pusty.", exception.getMessage());
    }

    @Test
    @DisplayName("Powinno rzucić wyjątek, gdy liczba składników jest ujemna")
    void shouldThrowExceptionWhenIngredientsAreNegative() {
        Pizza.Builder builder = new Pizza.Builder()
                .size(Pizza.Size.MEDIUM)
                .mushrooms(-1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, builder::build);
        assertEquals("Liczba porcji dodatków nie może być ujemna.", exception.getMessage());
    }

    @Test
    @DisplayName("Dyrektor powinien poprawnie przygotować pizzę Margherita")
    void directorShouldMakeMargherita() {
        PizzaDirector director = new PizzaDirector();
        Pizza margherita = director.makeMargherita(Pizza.Size.SMALL);

        assertEquals(Pizza.Size.SMALL, margherita.getSize());
        assertEquals(2, margherita.getCheese());
        assertEquals(0, margherita.getHam());
        assertEquals(0, margherita.getMushrooms());
        assertEquals(0, margherita.getOlives());
        assertEquals(0, margherita.getPepperoni());
    }

    @Test
    @DisplayName("Dyrektor powinien poprawnie przygotować pizzę Supreme")
    void directorShouldMakeSupreme() {
        PizzaDirector director = new PizzaDirector();
        Pizza supreme = director.makeSupreme(Pizza.Size.LARGE);

        assertEquals(Pizza.Size.LARGE, supreme.getSize());
        assertEquals(2, supreme.getCheese());
        assertEquals(1, supreme.getHam());
        assertEquals(2, supreme.getMushrooms());
        assertEquals(1, supreme.getOlives());
        assertEquals(2, supreme.getPepperoni());
    }

    @Test
    @DisplayName("Dyrektor powinien poprawnie skonstruować pizzę za pomocą przekazanego Buildera")
    void directorShouldConstructUsingProvidedBuilder() {
        PizzaDirector director = new PizzaDirector();
        Pizza.Builder builder = new Pizza.Builder();

        director.constructPepperoni(builder, Pizza.Size.MEDIUM);
        Pizza pepperoni = builder.build();

        assertEquals(Pizza.Size.MEDIUM, pepperoni.getSize());
        assertEquals(2, pepperoni.getCheese());
        assertEquals(3, pepperoni.getPepperoni());
    }

    @Test
    @DisplayName("Dyrektor powinien współpracować z PizzaMarketingBuilder i wygenerować poprawny opis")
    void directorShouldWorkWithMarketingBuilder() {
        PizzaDirector director = new PizzaDirector();
        PizzaMarketingBuilder marketingBuilder = new PizzaMarketingBuilder();

        director.constructSupreme(marketingBuilder, Pizza.Size.LARGE);
        String description = marketingBuilder.getResult();

        assertNotNull(description);
        assertTrue(description.contains("Duża XXL"));
        assertTrue(description.contains("mozzarella"));
        assertTrue(description.contains("szynka"));
        assertTrue(description.contains("pieczarki"));
        assertTrue(description.contains("oliwki"));
        assertTrue(description.contains("pepperoni"));
    }
}
