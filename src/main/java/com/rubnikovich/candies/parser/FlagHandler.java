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

public class FlagHandler extends DefaultHandler {

    private static final FlagHandler instance = new FlagHandler();
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

    private FlagHandler() {
    }

    public static FlagHandler getInstance() {
        return instance;
    }

    public Set<Candy> getCandies() {
        return Collections.unmodifiableSet(candies);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase(CandyXmlNode.CANDY.getTitle())) {
            candyValue = CandyValue.newBuilderValue().buldCandyValue();
            ingredients = Ingredients.newBuilderIngredients().buildIngredients();
            candy = Candy.newBuilderCandy().setCandyValue(candyValue).setIngredients(ingredients).buildCandy();
            candy.setBrand(attributes.getValue(CandyXmlNode.BRAND.getTitle()));
            candy.setType(CandyType.valueOf(attributes.getValue(CandyXmlNode.TYPE.getTitle())
                    .toUpperCase().replace(" ", "_")));
        } else if (qName.equalsIgnoreCase(CandyXmlNode.ENERGY.getTitle())) {
            caloriesFlag = true;
        } else if (qName.equalsIgnoreCase(CandyXmlNode.DATE.getTitle())) {
            dateFlag = true;
        } else if (qName.equalsIgnoreCase(CandyXmlNode.PRODUCTION.getTitle())) {
            productionFlag = true;
        } else if (qName.equalsIgnoreCase(CandyXmlNode.PROTEIN.getTitle())) {
            proteinFlag = true;
        } else if (qName.equalsIgnoreCase(CandyXmlNode.CARBOHYDRATES.getTitle())) {
            carbohydratesFlag = true;
        } else if (qName.equalsIgnoreCase(CandyXmlNode.FATS.getTitle())) {
            fatsFlag = true;
        } else if (qName.equalsIgnoreCase(CandyXmlNode.WATER.getTitle())) {
            waterFlag = true;
        } else if (qName.equalsIgnoreCase(CandyXmlNode.SUGAR.getTitle())) {
            sugarFlag = true;
        } else if (qName.equalsIgnoreCase(CandyXmlNode.FRUCTOSE.getTitle())) {
            fructoseFlag = true;
        } else if (qName.equalsIgnoreCase(CandyXmlNode.VANILLA.getTitle())) {
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
