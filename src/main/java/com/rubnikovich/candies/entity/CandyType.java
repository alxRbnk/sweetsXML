package com.rubnikovich.candies.entity;

public enum CandyType {
    CHOCOLATE("chocolate"),
    CHEWY_AND_FRUIT("chewy and fruit"),
    CARAMEL_AND_LOLLIPOPS("caramel and lollipops"),
    ENERGY("energy"),
    HOLIDAY("holiday");

    private String title;

    CandyType(String title){
        this.title = title;
    }

}

