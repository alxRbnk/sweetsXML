package com.rubnikovich.candies.entity;

public class CandyValue {
    private int protein;
    private int carbohydrates;
    private int fats;

    public CandyValue() {
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CandyValue{");
        sb.append("protein=").append(protein);
        sb.append(", carbohydrates=").append(carbohydrates);
        sb.append(", fats=").append(fats);
        sb.append('}');
        return sb.toString();
    }
}
