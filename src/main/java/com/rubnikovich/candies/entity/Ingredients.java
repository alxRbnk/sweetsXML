package com.rubnikovich.candies.entity;

public class Ingredients {
    private int water;
    private int sugar;
    private int fructose;
    private int vanilla;

    private Ingredients() {
    }

    public static BuilderIngredients newBuilderIngredients(){
        return new Ingredients().new BuilderIngredients();
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    public void setVanilla(int vanilla) {
        this.vanilla = vanilla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredients that = (Ingredients) o;

        if (water != that.water) return false;
        if (sugar != that.sugar) return false;
        if (fructose != that.fructose) return false;
        return vanilla == that.vanilla;
    }

    @Override
    public int hashCode() {
        int result = water;
        result = 31 * result + sugar;
        result = 31 * result + fructose;
        result = 31 * result + vanilla;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredients{");
        sb.append("water=").append(water);
        sb.append(", sugar=").append(sugar);
        sb.append(", fructose=").append(fructose);
        sb.append(", vanilla=").append(vanilla);
        sb.append('}');
        return sb.toString();
    }

    public class BuilderIngredients{

        private BuilderIngredients(){
        }

        public BuilderIngredients setWater(int water) {
            Ingredients.this.water = water;
            return this;
        }

        public BuilderIngredients setSugar(int sugar) {
            Ingredients.this.sugar = sugar;
            return this;
        }

        public BuilderIngredients setFructose(int fructose) {
            Ingredients.this.fructose = fructose;
            return this;
        }

        public BuilderIngredients setVanilla(int vanilla) {
            Ingredients.this.vanilla = vanilla;
            return this;
        }

        public Ingredients buildIngredients() {
            return Ingredients.this;
        }

    }

}
