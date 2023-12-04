package com.rubnikovich.candies.parser;

import com.rubnikovich.candies.entity.Candy;
import com.rubnikovich.candies.entity.CandyType;
import com.rubnikovich.candies.entity.CandyValue;
import com.rubnikovich.candies.entity.Ingredients;
import com.rubnikovich.candies.validator.ValidatorSaxXsd;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandyHandler extends DefaultHandler {
    private static final String ELEMENT_CANDY = "candy";
    private Set<Candy> candies = new HashSet<>();
    private Candy currentCandy;
    private CandyValue currentValue;
    private Ingredients currentIngredient;
    private CandyXmlNode currentNode;
    private EnumSet<CandyXmlNode> withText;

    public CandyHandler() {
        withText = EnumSet.range(CandyXmlNode.DATE, CandyXmlNode.VANILLA);
    }

    public Set<Candy> getCandies() {
        return Collections.unmodifiableSet(candies);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_CANDY.equals(qName)) {
            currentValue = CandyValue.newBuilderValue().buldCandyValue();
            currentIngredient = Ingredients.newBuilderIngredients().buildIngredients();
            currentCandy = Candy.newBuilderCandy().setIngredients(currentIngredient).setCandyValue(currentValue).buildCandy();
            if (isCandyType(attrs)) {
                setAttributes(attrs, 1, 0);
            } else {
                setAttributes(attrs, 0, 1);
            }
        } else {
            CandyXmlNode temp = CandyXmlNode.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentNode = temp;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);
        if (currentNode == CandyXmlNode.DATE) {
            currentCandy.setDate(LocalDate.parse(data));
        } else if (currentNode == CandyXmlNode.PRODUCTION) {
            currentCandy.setProduction(data);
        } else if (currentNode == CandyXmlNode.ENERGY) {
            currentCandy.setEnergy(Integer.parseInt(data));
        } else if (currentNode == CandyXmlNode.PROTEIN) {
            currentValue.setProtein(Integer.parseInt(data));
        } else if (currentNode == CandyXmlNode.CARBOHYDRATES) {
            currentValue.setCarbohydrates(Integer.parseInt(data));
        } else if (currentNode == CandyXmlNode.FATS) {
            currentValue.setFats(Integer.parseInt(data));
        } else if (currentNode == CandyXmlNode.WATER) {
            currentIngredient.setWater(Integer.parseInt(data));
        } else if (currentNode == CandyXmlNode.SUGAR) {
            currentIngredient.setSugar(Integer.parseInt(data));
        } else if (currentNode == CandyXmlNode.FRUCTOSE) {
            currentIngredient.setFructose(Integer.parseInt(data));
        } else if (currentNode == CandyXmlNode.VANILLA) {
            currentIngredient.setVanilla(Integer.parseInt(data));
        }
        currentNode = null;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_CANDY.equals(qName)) {
            candies.add(currentCandy);
        }
    }

    private boolean isCandyType(Attributes attrs) {
        boolean match = false;
        try {
            CandyType.valueOf(attrs.getValue(0).toUpperCase().replace(" ", "_"));
            match = true;
        } catch (IllegalArgumentException ignored) {
            ValidatorSaxXsd.logger.atWarn();
          }
        return match;
    }

    private void setAttributes(Attributes attrs, int first, int second) {
        currentCandy.setBrand(attrs.getValue(first));
        currentCandy.setType(CandyType.valueOf((attrs.getValue(second)).toUpperCase().replace(" ", "_")));
    }
}
