package com.rubnikovich.candies.parser;

import com.rubnikovich.candies.exception.CustomException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class FlagSAX {

    private static final String PATH = "files/candies.xml";
    private SAXParserFactory factory = SAXParserFactory.newInstance();
    private SAXParser saxParser;

    public FlagSAX() throws CustomException {
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            throw new CustomException(" " + e);
        } catch (SAXException e) {
            throw new CustomException(" " + e);
        }
    }

    public void customParseSAX() throws CustomException {
        try {
            saxParser.parse(PATH, FlagHandler.getInstance());
        } catch (SAXException e) {
            throw new CustomException(" " + e);
        } catch (IOException e) {
            throw new CustomException(" " + e);
        }
    }



}
