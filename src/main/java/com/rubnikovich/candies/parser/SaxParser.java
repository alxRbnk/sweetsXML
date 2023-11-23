package com.rubnikovich.candies.parser;

import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser {                            //fixme
    public void saxParese() {
        try {
            SaxHandler handler = new SaxHandler();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse("files/candies.xml");
        } catch (SAXException e) {
            System.err.print("SAX parser exception: " + e);
        } catch (IOException e) {
            System.err.print("I/О exception: " + e);
        } catch (ParserConfigurationException e) {
            System.err.print("Configuration exception: " + e);
        }
    }
}
