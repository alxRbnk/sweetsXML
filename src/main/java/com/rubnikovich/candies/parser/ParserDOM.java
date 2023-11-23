package com.rubnikovich.candies.parser;

import com.rubnikovich.candies.entity.Candy;
import com.rubnikovich.candies.entity.CandyType;
import com.rubnikovich.candies.entity.CandyValue;
import com.rubnikovich.candies.entity.Ingredients;
import com.rubnikovich.candies.exception.CustomException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ParserDOM {
    private static final String PATH = "files/candies.xml";
    private Set<Candy> candies;
    DocumentBuilder builder;

    public ParserDOM() throws CustomException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new CustomException("error configuration" + e);
        }
    }

    public Set<Candy> getCandies() {
        return Collections.unmodifiableSet(candies);
    }

    public void buildCandiesSet() throws CustomException {
        Document document = null;
        try {
            document = builder.parse(new File(PATH));
        } catch (SAXException e) {
            throw new CustomException("parsing file" + e);
        } catch (IOException e) {
            throw new CustomException("file is invalid" + e);
        }
        candies = new HashSet<>();
        NodeList root = document.getDocumentElement().getElementsByTagName("candy");
        for (int i = 0; i < root.getLength(); i++) {
            Element element = (Element) root.item(i);
            candies.add(buildCandy(element));
        }
    }

    private Candy buildCandy(Element element) {
        Candy candy = Candy.newBuilderCandy()
                .setBrand(element.getAttribute("brand"))
                .setType(CandyType.valueOf((getElementText(element, "type"))))
                .setEnergy(Integer.parseInt(getElementText(element, "energy")))
                .setDate(LocalDate.parse(getElementText(element, "date")))
                .setProduction(getElementText(element, "production"))
                .setCandyValue(CandyValue.newBuilderValue()
                        .setProtein(Integer.parseInt(getElementText(element, "protein")))
                        .setCarbohydrates(Integer.parseInt(getElementText(element, "carbohydrates")))
                        .setFats(Integer.parseInt(getElementText(element, "fats")))
                        .buldCandyValue())
                .setIngredients(Ingredients.newBuilderIngredients()
                        .setWater(Integer.parseInt(getElementText(element, "water")))
                        .setSugar(Integer.parseInt(getElementText(element, "sugar")))
                        .setFructose(Integer.parseInt(getElementText(element, "fructose")))
                        .setVanilla(Integer.parseInt(getElementText(element, "vanilla")))
                        .buildIngredients())
                .buildCandy();
        return candy;
    }

    private String getElementText(Element element, String tagName) {
        return tagName.equals("type") ?
                element.getElementsByTagName(tagName).item(0).getTextContent().toUpperCase().replace(" ", "_") :
                element.getElementsByTagName(tagName).item(0).getTextContent();
    }
}
