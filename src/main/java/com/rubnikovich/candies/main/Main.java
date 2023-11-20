package com.rubnikovich.candies.main;

import com.rubnikovich.candies.parser.ParserDOM;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        ParserDOM parser = new ParserDOM();
//        parser.getCandies().add(new Candy());
        parser.getCandies().forEach(System.out::println);



//        //SAX
//        String fileName = "files/candies.xml";
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser saxParser = factory.newSAXParser();
//        DefaultHandler hundler = new DefaultHandler(){
//
//            boolean brandFlag = false;
//            boolean typeFlag = false;
//            boolean caloriesFlag = false;
//            boolean dateFlag = false;
//            boolean productionFlag = false;
//            boolean proteinFlag = false;
//            boolean carbohydratesFlag = false;
//            boolean fatsFlag = false;
//            boolean waterFlag = false;
//            boolean sugarFlag = false;
//            boolean fructoseFlag = false;
//            boolean vanillaFlag = false;
//
//            @Override
//            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//                if (qName.equalsIgnoreCase("candy")) {
//                    System.out.println("Brand: " + attributes.getValue("brand"));
//                    System.out.println("Type: " + attributes.getValue("type"));
//                } else if (qName.equalsIgnoreCase("energy")) {
//                    caloriesFlag = true;
//                } else if (qName.equalsIgnoreCase("date")) {
//                    dateFlag = true;
//                } else if (qName.equalsIgnoreCase("production")) {
//                    productionFlag = true;
//                } else if (qName.equalsIgnoreCase("protein")) {
//                    proteinFlag = true;
//                } else if (qName.equalsIgnoreCase("carbohydrates")) {
//                    carbohydratesFlag = true;
//                } else if (qName.equalsIgnoreCase("fats")) {
//                    fatsFlag = true;
//                } else if (qName.equalsIgnoreCase("water")) {
//                    waterFlag = true;
//                } else if (qName.equalsIgnoreCase("sugar")) {
//                    sugarFlag = true;
//                } else if (qName.equalsIgnoreCase("fructose")) {
//                    fructoseFlag = true;
//                } else if (qName.equalsIgnoreCase("vanilla")) {
//                    vanillaFlag = true;
//                }
//            }
//
//            @Override
//            public void characters(char[] ch, int start, int length) throws SAXException {
//                if (caloriesFlag) {
//                    System.out.println("Energy - Calories: " + new String(ch, start, length));
//                    caloriesFlag = false;
//                } else if (dateFlag) {
//                    System.out.println("Date: " + new String(ch, start, length));
//                    dateFlag = false;
//                } else if (productionFlag) {
//                    System.out.println("Production: " + new String(ch, start, length));
//                    productionFlag = false;
//                } else if (proteinFlag) {
//                    System.out.println("Value - Protein: " + new String(ch, start, length) + "g");
//                    proteinFlag = false;
//                } else if (carbohydratesFlag) {
//                    System.out.println("Value - Carbohydrates: " + new String(ch, start, length) + "g");
//                    carbohydratesFlag = false;
//                } else if (fatsFlag) {
//                    System.out.println("Value - Fats: " + new String(ch, start, length) + "g");
//                    fatsFlag = false;
//                } else if (waterFlag) {
//                    System.out.println("Ingredients - Water: " + new String(ch, start, length) + "%");
//                    waterFlag = false;
//                } else if (sugarFlag) {
//                    System.out.println("Ingredients - Sugar: " + new String(ch, start, length) + "%");
//                    sugarFlag = false;
//                } else if (fructoseFlag) {
//                    System.out.println("Ingredients - Fructose: " + new String(ch, start, length) + "%");
//                    fructoseFlag = false;
//                } else if (vanillaFlag) {
//                    System.out.println("Ingredients - Vanilla: " + new String(ch, start, length) + "%");
//                    vanillaFlag = false;
//                }
//            }
//        };
//
//        saxParser.parse(fileName, hundler);
    }
}
