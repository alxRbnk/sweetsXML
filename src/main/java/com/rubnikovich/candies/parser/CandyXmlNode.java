package com.rubnikovich.candies.parser;

public enum CandyXmlNode {
    CANDIES("candies"),
    BRAND("brand"),
    TYPE("type"),
    CANDY("candy"),
    DATE("date"),
    PRODUCTION("production"),
    ENERGY("energy"),
    VALUE("value"),
    PROTEIN("protein"),
    CARBOHYDRATES("carbohydrates"),
    FATS("fats"),
    INGREDIENTS("ingredients"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    VANILLA("vanilla");

    private String title;

    CandyXmlNode(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
