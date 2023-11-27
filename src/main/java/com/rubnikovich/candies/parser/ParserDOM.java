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
    private DocumentBuilder builder;

    public ParserDOM() throws CustomException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new CustomException("error configuration", e);
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
            throw new CustomException("parsing file", e);
        } catch (IOException e) {
            throw new CustomException("file is invalid", e);
        }
        candies = new HashSet<>();
        NodeList root = document.getDocumentElement().getElementsByTagName(CandyXmlNode.CANDY.getTitle());
        for (int i = 0; i < root.getLength(); i++) {
            Element element = (Element) root.item(i);
            candies.add(buildCandy(element));
        }
    }

    private Candy buildCandy(Element element) {
        return Candy.newBuilderCandy()
                .setBrand(element.getAttribute(CandyXmlNode.BRAND.getTitle()))
                .setType(CandyType.valueOf((element.getAttribute(CandyXmlNode.TYPE.getTitle())
                        .replace(" ","_").toUpperCase())))
                .setEnergy(Integer.parseInt(getElementText(element, CandyXmlNode.ENERGY)))
                .setDate(LocalDate.parse(getElementText(element, CandyXmlNode.DATE)))
                .setProduction(getElementText(element, CandyXmlNode.PRODUCTION))
                .setCandyValue(CandyValue.newBuilderValue()
                        .setProtein(Integer.parseInt(getElementText(element, CandyXmlNode.PROTEIN)))
                        .setCarbohydrates(Integer.parseInt(getElementText(element, CandyXmlNode.CARBOHYDRATES)))
                        .setFats(Integer.parseInt(getElementText(element, CandyXmlNode.FATS)))
                        .buldCandyValue())
                .setIngredients(Ingredients.newBuilderIngredients()
                        .setWater(Integer.parseInt(getElementText(element, CandyXmlNode.WATER)))
                        .setSugar(Integer.parseInt(getElementText(element, CandyXmlNode.SUGAR)))
                        .setFructose(Integer.parseInt(getElementText(element, CandyXmlNode.FRUCTOSE)))
                        .setVanilla(Integer.parseInt(getElementText(element, CandyXmlNode.VANILLA)))
                        .buildIngredients())
                .buildCandy();
    }

    private String getElementText(Element element, CandyXmlNode enumNode) {
        return element.getElementsByTagName(enumNode.getTitle()).item(0).getTextContent();
    }
}
