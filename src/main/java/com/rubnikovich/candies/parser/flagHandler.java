package com.rubnikovich.candies.parser;

import com.rubnikovich.candies.entity.Candy;
import com.rubnikovich.candies.entity.CandyType;
import com.rubnikovich.candies.entity.CandyValue;
import com.rubnikovich.candies.entity.Ingredients;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class flagHandler extends DefaultHandler {

    private static final flagHandler instance = new flagHandler();
    private boolean caloriesFlag = false;
    private boolean dateFlag = false;
    private boolean productionFlag = false;
    private boolean proteinFlag = false;
    private boolean carbohydratesFlag = false;
    private boolean fatsFlag = false;
    private boolean waterFlag = false;
    private boolean sugarFlag = false;
    private boolean fructoseFlag = false;
    private boolean vanillaFlag = false;
    private Set<Candy> candies = new HashSet<>();
    private Candy candy;
    private CandyValue candyValue;
    private Ingredients ingredients;

    private flagHandler() {
    }

    public static flagHandler getInstance() {
        return instance;
    }

    public Set<Candy> getCandies() {
        return Collections.unmodifiableSet(candies);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("candy")) {
            candyValue = CandyValue.newBuilderValue().buldCandyValue();
            ingredients = Ingredients.newBuilderIngredients().buildIngredients();
            candy = Candy.newBuilderCandy().setCandyValue(candyValue).setIngredients(ingredients).buildCandy();
            candy.setBrand(attributes.getValue("brand"));
            candy.setType(CandyType.valueOf(attributes.getValue("type").toUpperCase().replace(" ", "_")));
        } else if (qName.equalsIgnoreCase("energy")) {
            caloriesFlag = true;
        } else if (qName.equalsIgnoreCase("date")) {
            dateFlag = true;
        } else if (qName.equalsIgnoreCase("production")) {
            productionFlag = true;
        } else if (qName.equalsIgnoreCase("protein")) {
            proteinFlag = true;
        } else if (qName.equalsIgnoreCase("carbohydrates")) {
            carbohydratesFlag = true;
        } else if (qName.equalsIgnoreCase("fats")) {
            fatsFlag = true;
        } else if (qName.equalsIgnoreCase("water")) {
            waterFlag = true;
        } else if (qName.equalsIgnoreCase("sugar")) {
            sugarFlag = true;
        } else if (qName.equalsIgnoreCase("fructose")) {
            fructoseFlag = true;
        } else if (qName.equalsIgnoreCase("vanilla")) {
            vanillaFlag = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (caloriesFlag) {
            candy.setEnergy(Integer.parseInt(new String(ch, start, length)));
            caloriesFlag = false;
        } else if (dateFlag) {
            candy.setDate(LocalDate.parse(new String(ch, start, length)));
            dateFlag = false;
        } else if (productionFlag) {
            candy.setProduction(new String(ch, start, length));
            productionFlag = false;
        } else if (proteinFlag) {
            candyValue.setProtein(Integer.parseInt(new String(ch, start, length)));
            proteinFlag = false;
        } else if (carbohydratesFlag) {
            candyValue.setCarbohydrates(Integer.parseInt(new String(ch, start, length)));
            carbohydratesFlag = false;
        } else if (fatsFlag) {
            candyValue.setFats(Integer.parseInt(new String(ch, start, length)));
            fatsFlag = false;
        } else if (waterFlag) {
            ingredients.setWater(Integer.parseInt(new String(ch, start, length)));
            waterFlag = false;
        } else if (sugarFlag) {
            ingredients.setSugar(Integer.parseInt(new String(ch, start, length)));
            sugarFlag = false;
        } else if (fructoseFlag) {
            ingredients.setFructose(Integer.parseInt(new String(ch, start, length)));
            fructoseFlag = false;
        } else if (vanillaFlag) {
            ingredients.setVanilla(Integer.parseInt(new String(ch, start, length)));
            vanillaFlag = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        candies.add(candy);
    }
}
