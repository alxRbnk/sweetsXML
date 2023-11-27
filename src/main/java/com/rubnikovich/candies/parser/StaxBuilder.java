package com.rubnikovich.candies.parser;

import com.google.protobuf.Value;
import com.rubnikovich.candies.entity.Candy;
import com.rubnikovich.candies.entity.CandyType;
import com.rubnikovich.candies.entity.CandyValue;
import com.rubnikovich.candies.entity.Ingredients;
import com.rubnikovich.candies.exception.CustomException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxBuilder {
    private Set<Candy> candies;
    private XMLInputFactory inputFactory;

    public StaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        candies = new HashSet<>();
    }

    public Set<Candy> getCandies() {
        return Collections.unmodifiableSet(candies);
    }

    public void buildSetCandies(String filename) throws CustomException {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(CandyXmlNode.CANDY.getTitle())) {
                        Candy candy = buildCandy(reader);
                        candies.add(candy);
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    private Candy buildCandy(XMLStreamReader reader) throws CustomException {
        Candy candy = Candy.newBuilderCandy().buildCandy();
        candy.setBrand(reader.getAttributeValue(null, CandyXmlNode.BRAND.getTitle()));
        candy.setType(CandyType.valueOf((reader.getAttributeValue(null, CandyXmlNode.TYPE.getTitle()))
                .toUpperCase().replaceAll(" ", "_")));
        String name;
        try {
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    switch (CandyXmlNode.valueOf(name.toUpperCase())) {
                        case DATE -> candy.setDate(LocalDate.parse(getXMLText(reader)));
                        case PRODUCTION -> candy.setProduction(getXMLText(reader));
                        case ENERGY -> candy.setEnergy(Integer.parseInt(getXMLText(reader)));
                        case INGREDIENTS -> candy.setIngredients(getXmlIngredients(reader));
                        case VALUE -> candy.setValue(getXMLValue(reader));
                    }
                } else if (type == XMLStreamConstants.END_ELEMENT) {
                    name = reader.getLocalName();
                    if (CandyXmlNode.valueOf(name.toUpperCase()) == CandyXmlNode.CANDY) {
                        return candy;
                    }
                }
            }
            throw new CustomException("Unknown element in tag <candy>");
        } catch (XMLStreamException e) {
            throw new CustomException(" ", e);
        }
    }

    private Ingredients getXmlIngredients(XMLStreamReader reader) throws CustomException {
        Ingredients ingredients = Ingredients.newBuilderIngredients().buildIngredients();
        int type;
        String name;
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (CandyXmlNode.valueOf(name.toUpperCase())) {
                            case WATER -> ingredients.setWater(Integer.parseInt(getXMLText(reader)));
                            case SUGAR -> ingredients.setSugar(Integer.parseInt(getXMLText(reader)));
                            case FRUCTOSE -> ingredients.setFructose(Integer.parseInt(getXMLText(reader)));
                            case VANILLA -> ingredients.setVanilla(Integer.parseInt(getXMLText(reader)));
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (CandyXmlNode.valueOf(name.toUpperCase()) == CandyXmlNode.INGREDIENTS) {
                            return ingredients;
                        }
                }
            }
            throw new CustomException("Unknown element in tag <Ingredients>");
        } catch (XMLStreamException e) {
            throw new CustomException(" ", e);
        }
    }

    private CandyValue getXMLValue(XMLStreamReader reader) throws CustomException {
        CandyValue candyValue = CandyValue.newBuilderValue().buldCandyValue();
        int type;
        String name;
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (CandyXmlNode.valueOf(name.toUpperCase())) {
                            case PROTEIN -> candyValue.setProtein(Integer.parseInt(getXMLText(reader)));
                            case CARBOHYDRATES -> candyValue.setCarbohydrates(Integer.parseInt(getXMLText(reader)));
                            case FATS -> candyValue.setFats(Integer.parseInt(getXMLText(reader)));
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (CandyXmlNode.valueOf(name.toUpperCase()) == CandyXmlNode.VALUE) {
                            return candyValue;
                        }
                }
            }
            throw new CustomException("Unknown element in tag CandyValue");
        } catch (XMLStreamException e) {
            throw new CustomException(" ", e);
        }
    }

    private String getXMLText(XMLStreamReader reader) throws CustomException {
        String text = null;
        try {
            if (reader.hasNext()) {
                reader.next();
                text = reader.getText();
            }
        } catch (XMLStreamException e) {
            throw new CustomException(" ", e);
        }
        return text;
    }
}

