package com.rubnikovich.candies.parser;

import com.rubnikovich.candies.entity.Candy;
import com.rubnikovich.candies.exception.CustomException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public class CandySaxBuilder {
    private Set<Candy> candies;
    private CandyHandler handler = new CandyHandler();
    private XMLReader reader;

    public CandySaxBuilder() throws CustomException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            throw new CustomException("error configuration or invalid file", e);
        }
        reader.setErrorHandler(new CandyErrorHandler());
        reader.setContentHandler(handler);
    }

    public Set<Candy> getCandies() {
        return Collections.unmodifiableSet(candies);
    }

    public void buildSetCandies(String filename) throws CustomException {
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            throw new CustomException("parsing file or invalid file", e);
        }
        candies = handler.getCandies();
    }
}
