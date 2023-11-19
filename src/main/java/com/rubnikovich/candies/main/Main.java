package com.rubnikovich.candies.main;

import com.rubnikovich.candies.entity.Candy;
import com.rubnikovich.candies.parser.ParserDOM;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        ParserDOM parser = new ParserDOM();
//        parser.getCandies().add(new Candy());
        parser.getCandies().forEach(System.out::println);

    }
}
