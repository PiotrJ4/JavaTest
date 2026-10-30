package example.pizza;

public class Pizza {
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    private final int cheese;
    private final int ham;
    private final int mushrooms;
    private final int olives;
    private final int pepperoni;
    private final Size size;

    public Pizza(int cheese, int ham, int mushrooms, int olives, int pepperoni, Size size) {
        if (cheese < 0 || ham < 0 || mushrooms < 0 || olives < 0 || pepperoni < 0) {
            throw new IllegalArgumentException("Liczba porcji dodatków nie może być ujemna.");
        }
        if (size == null) {
            throw new IllegalArgumentException("Rozmiar pizzy nie może być pusty.");
        }

        this.cheese = cheese;
        this.ham = ham;
        this.mushrooms = mushrooms;
        this.olives = olives;
        this.pepperoni = pepperoni;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "rozmiar=" + size +
                ", ser=" + cheese +
                ", szynka=" + ham +
                ", pieczarki=" + mushrooms +
                ", oliwki=" + olives +
                ", pepperoni=" + pepperoni +
                '}';
    }
}
