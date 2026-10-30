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

    private Pizza(Builder builder) {
        if (builder.cheese < 0 || builder.ham < 0 || builder.mushrooms < 0 || builder.olives < 0 || builder.pepperoni < 0) {
            throw new IllegalArgumentException("Liczba porcji dodatków nie może być ujemna.");
        }
        if (builder.size == null) {
            throw new IllegalArgumentException("Rozmiar pizzy nie może być pusty.");
        }

        this.cheese = builder.cheese;
        this.ham = builder.ham;
        this.mushrooms = builder.mushrooms;
        this.olives = builder.olives;
        this.pepperoni = builder.pepperoni;
        this.size = builder.size;
    }

    public int getCheese() {
        return cheese;
    }

    public int getHam() {
        return ham;
    }

    public int getMushrooms() {
        return mushrooms;
    }

    public int getOlives() {
        return olives;
    }

    public int getPepperoni() {
        return pepperoni;
    }

    public Size getSize() {
        return size;
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

    public static class Builder {
        private Size size;
        private int cheese = 0;
        private int ham = 0;
        private int mushrooms = 0;
        private int olives = 0;
        private int pepperoni = 0;

        public Builder() {
        }

        public Builder(Size size) {
            this.size = size;
        }

        public Builder reset() {
            this.size = null;
            this.cheese = 0;
            this.ham = 0;
            this.mushrooms = 0;
            this.olives = 0;
            this.pepperoni = 0;
            return this;
        }

        public Builder size(Size size) {
            this.size = size;
            return this;
        }

        public Builder cheese(int cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder ham(int ham) {
            this.ham = ham;
            return this;
        }

        public Builder mushrooms(int mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        public Builder olives(int olives) {
            this.olives = olives;
            return this;
        }

        public Builder pepperoni(int pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
