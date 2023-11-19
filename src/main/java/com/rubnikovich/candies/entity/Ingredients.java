package com.rubnikovich.candies.entity;

public class Ingredients {
    private int water;
    private int sugar;
    private int fructose;
    private int vanilla;

    public Ingredients() {
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getFructose() {
        return fructose;
    }

    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    public int getVanilla() {
        return vanilla;
    }

    public void setVanilla(int vanilla) {
        this.vanilla = vanilla;
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
}
