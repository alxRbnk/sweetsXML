package com.rubnikovich.candies.parser;

import com.rubnikovich.candies.entity.Candy;
import com.rubnikovich.candies.entity.CandyType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CustomHandler extends DefaultHandler {

    private static final CustomHandler instance = new CustomHandler();
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

    private CustomHandler() {
    }

    public static CustomHandler getInstance() {
        return instance;
    }

    public Set<Candy> getCandies(){
        return candies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("candy")) {
            System.out.println("Brand " + attributes.getValue("brand"));
            System.out.println("Type: " + attributes.getValue("type"));
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
//            System.out.println("Energy " + new String(ch, start, length));
            caloriesFlag = false;
        } else if (dateFlag) {
//            System.out.println("Date " + new String(ch, start, length));
            dateFlag = false;
        } else if (productionFlag) {
//            System.out.println("Production " + new String(ch, start, length));
            productionFlag = false;
        } else if (proteinFlag) {
//            System.out.println("Protein " + new String(ch, start, length));
            proteinFlag = false;
        } else if (carbohydratesFlag) {
//            System.out.println("Carbohydrates " + new String(ch, start, length));
            carbohydratesFlag = false;
        } else if (fatsFlag) {
//            System.out.println("Fats " + new String(ch, start, length));
            fatsFlag = false;
        } else if (waterFlag) {
//            System.out.println("Water " + new String(ch, start, length));
            waterFlag = false;
        } else if (sugarFlag) {
//            System.out.println("Sugar " + new String(ch, start, length));
            sugarFlag = false;
        } else if (fructoseFlag) {
//            System.out.println("Fructose " + new String(ch, start, length));
            fructoseFlag = false;
        } else if (vanillaFlag) {
//            System.out.println("Vanilla " + new String(ch, start, length));
            vanillaFlag = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }
}
