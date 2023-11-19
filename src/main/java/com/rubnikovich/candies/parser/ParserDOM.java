package com.rubnikovich.candies.parser;

import com.rubnikovich.candies.entity.Candy;
import com.rubnikovich.candies.entity.CandyType;
import com.rubnikovich.candies.entity.CandyValue;
import com.rubnikovich.candies.entity.Ingredients;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
    private Set<Candy> candies;
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder builder = factory.newDocumentBuilder();
    private Document document = builder.parse(new File("files/candies.xml"));

    public ParserDOM() throws IOException, SAXException, ParserConfigurationException {
        candies = buildCandies();
    }

    public Set<Candy> getCandies() {
        return Collections.unmodifiableSet(candies);
    }

    private Set<Candy> buildCandies() {
        Set<Candy> setCandies = new HashSet<>();
        for (int i = 0; i < buildNodeList("candy").getLength(); i++) {
            setCandies.add(buildCandy(i));
        }
        return setCandies;
    }

    private NodeList buildNodeList(String element) {
        return document.getDocumentElement().getElementsByTagName(element);
    }

    private Node buildNode(String element, int index){
        return buildNodeList(element).item(index);
    }

    private NamedNodeMap buildNodeMap(String element, int number){
        return buildNode(element, number).getAttributes();
    }

    private Candy buildCandy(int number) {
        Candy candy = new Candy();
        candy.setBrand(buildNodeMap("candy",number).getNamedItem("brand").getNodeValue());
        String stringType = buildNodeMap("candy",number).getNamedItem("type").getNodeValue();
        candy.setType(CandyType.valueOf(stringType.toUpperCase().strip().replaceAll(" ", "_")));
        candy.setEnergy(Integer.parseInt(buildNodeMap("energy",number).getNamedItem("calories").getNodeValue()));
        candy.setDate(LocalDate.parse(buildNode("date",number).getTextContent()));
        candy.setProduction(buildNode("production",number).getTextContent());
        candy.setValue(buildCandyValue(number));
        candy.setIngredients(builtIngredients(number));
        return candy;
    }

    private Ingredients builtIngredients(int number){
        Ingredients ingredients = new Ingredients();
        ingredients.setWater(Integer.parseInt(buildNodeMap("water",number).getNamedItem("percent").getNodeValue()));
        ingredients.setSugar(Integer.parseInt(buildNodeMap("sugar",number).getNamedItem("percent").getNodeValue()));
        ingredients.setFructose(Integer.parseInt(buildNodeMap("fructose", number).getNamedItem("percent").getNodeValue()));
        ingredients.setVanilla(Integer.parseInt(buildNodeMap("vanilla",number).getNamedItem("percent").getNodeValue()));
        return ingredients;
    }

    private CandyValue buildCandyValue(int number){
        CandyValue candyValue = new CandyValue();
        candyValue.setProtein(Integer.parseInt(buildNodeMap("protein",number).getNamedItem("gram").getNodeValue()));
        candyValue.setCarbohydrates(Integer.parseInt(buildNodeMap("carbohydrates",number).getNamedItem("gram").getNodeValue()));
        candyValue.setFats(Integer.parseInt(buildNodeMap("fats",number).getNamedItem("gram").getNodeValue()));
        return candyValue;
    }

}
