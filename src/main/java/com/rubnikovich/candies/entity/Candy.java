package com.rubnikovich.candies.entity;

import java.time.LocalDate;

public class Candy {
    private String brand;
    private CandyType type;
    private int energy;
    private LocalDate date;
    private String production;
    private CandyValue value;
    private Ingredients ingredients;

    public Candy() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public CandyType getType() {
        return type;
    }

    public void setType(CandyType type) {
        this.type = type;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public CandyValue getValue() {
        return value;
    }

    public void setValue(CandyValue value) {
        this.value = value;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
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
}
