package example.pizza;

/**
 * Alternatywna implementacja budowniczego (Marketing/Ad Builder).
 * Zamiast tworzyć obiekt domeny (Pizza), gromadzi konfigurację i generuje
 * atrakcyjny, marketingowy opis reklamowy pizzy do karty dań, social media lub ulotki.
 */
public class PizzaMarketingBuilder implements PizzaBuilder {
    private Pizza.Size size;
    private int cheese;
    private int ham;
    private int mushrooms;
    private int olives;
    private int pepperoni;

    public PizzaMarketingBuilder() {
        reset();
    }

    @Override
    public PizzaMarketingBuilder reset() {
        this.size = null;
        this.cheese = 0;
        this.ham = 0;
        this.mushrooms = 0;
        this.olives = 0;
        this.pepperoni = 0;
        return this;
    }

    @Override
    public PizzaMarketingBuilder size(Pizza.Size size) {
        this.size = size;
        return this;
    }

    @Override
    public PizzaMarketingBuilder cheese(int count) {
        this.cheese = count;
        return this;
    }

    @Override
    public PizzaMarketingBuilder ham(int count) {
        this.ham = count;
        return this;
    }

    @Override
    public PizzaMarketingBuilder mushrooms(int count) {
        this.mushrooms = count;
        return this;
    }

    @Override
    public PizzaMarketingBuilder olives(int count) {
        this.olives = count;
        return this;
    }

    @Override
    public PizzaMarketingBuilder pepperoni(int count) {
        this.pepperoni = count;
        return this;
    }

    /**
     * Zwraca gotowy, zredagowany tekst marketingowy przygotowany na podstawie zgromadzonych składników.
     */
    public String getResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("🍕 === SPECJALNOŚĆ NASZEJ PIZZERII === 🍕\n");

        if (size != null) {
            String sizeText = switch (size) {
                case SMALL -> "Mała (idealna na lekki lunch i szybki zastrzyk energii)";
                case MEDIUM -> "Średnia (klasyczny wybór dla prawdziwego smakosza)";
                case LARGE -> "Duża XXL (monumentalna uczta stworzona do dzielenia się z bliskimi)";
            };
            sb.append("Format: ").append(sizeText).append("\n");
        } else {
            sb.append("Format: Do wyboru według życzenia gościa\n");
        }

        sb.append("Kompozycja smaków prosto z pieca opalanego drewnem:\n");
        boolean hasIngredients = false;

        if (cheese > 0) {
            sb.append("  🧀 ").append(cheese).append("x złocista, aksamitna mozzarella rozpływająca się w ustach\n");
            hasIngredients = true;
        }
        if (ham > 0) {
            sb.append("  🍖 ").append(ham).append("x tradycyjna szynka parmeńska o głębokim, szlachetnym aromacie\n");
            hasIngredients = true;
        }
        if (mushrooms > 0) {
            sb.append("  🍄 ").append(mushrooms).append("x świeże, leśne pieczarki podsmażane z ziołami\n");
            hasIngredients = true;
        }
        if (olives > 0) {
            sb.append("  🫒 ").append(olives).append("x dojrzałe w słońcu oliwki kalamata z nutą oliwy extra virgin\n");
            hasIngredients = true;
        }
        if (pepperoni > 0) {
            sb.append("  🌶️ ").append(pepperoni).append("x pikantne, chrupiące plastry salami pepperoni z ognistym akcentem\n");
            hasIngredients = true;
        }

        if (!hasIngredients) {
            sb.append("  🌿 Klasyczne ciasto na zaczynie drożdżowym z aromatycznym sosem z pomidorów San Marzano\n");
        }

        sb.append("Podawana ze świeżą bazylią. Gwarancja niezapomnianych doznań kulinarnych!");
        return sb.toString();
    }

    /**
     * Wypisuje wygenerowany opis marketingowy bezpośrednio do konsoli.
     */
    public void printDescription() {
        System.out.println(getResult());
    }
}
