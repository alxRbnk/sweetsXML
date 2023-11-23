package com.rubnikovich.candies.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Candy {
    private String brand;
    private CandyType type;
    private int energy;
    private LocalDate date;
    private String production;
    private CandyValue value;
    private Ingredients ingredients;

    private Candy() {
    }

    public static BuilderCandy newBuilderCandy() {
        return new Candy().new BuilderCandy();
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(CandyType type) {
        this.type = type;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public void setValue(CandyValue value) {
        this.value = value;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candy candy = (Candy) o;

        if (energy != candy.energy) return false;
        if (!Objects.equals(brand, candy.brand)) return false;
        if (type != candy.type) return false;
        if (!Objects.equals(date, candy.date)) return false;
        if (!Objects.equals(production, candy.production)) return false;
        if (!Objects.equals(value, candy.value)) return false;
        return Objects.equals(ingredients, candy.ingredients);
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + energy;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (production != null ? production.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Candy{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", type=").append(type);
        sb.append(", energy=").append(energy);
        sb.append(", date=").append(date);
        sb.append(", production='").append(production).append('\'');
        sb.append(", value=").append(value);
        sb.append(", ingredients=").append(ingredients);
        sb.append('}');
        return sb.toString();
    }

    public class BuilderCandy {

        public BuilderCandy setBrand(String userId) {
            Candy.this.brand = userId;
            return this;
        }

        public BuilderCandy setType(CandyType type) {
            Candy.this.type = type;
            return this;
        }
        public BuilderCandy setEnergy(int energy) {
            Candy.this.energy = energy;
            return this;
        }

        public BuilderCandy setDate(LocalDate date) {
            Candy.this.date = date;
            return this;
        }
        public BuilderCandy setProduction(String production) {
            Candy.this.production = production;
            return this;
        }

        public BuilderCandy setCandyValue(CandyValue value) {
            Candy.this.value = value;
            return this;
        }

        public BuilderCandy setIngredients(Ingredients ingredients) {
            Candy.this.ingredients = ingredients;
            return this;
        }

        public Candy buildCandy() {
            return Candy.this;
        }

    }
}
