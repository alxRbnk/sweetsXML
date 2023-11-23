package com.rubnikovich.candies.parser;


import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.Attributes;

public class SaxHandler implements ContentHandler {   //fixme
    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void startDocument() {
        System.out.println("Parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attrs) {
        String tagData = localName;
        for (int i = 0; i < attrs.getLength(); i++) {
            tagData += " " + attrs.getLocalName(i) + "=" + attrs.getValue(i);
        }
        System.out.print(tagData.strip());
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.print(new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) {
    }

    @Override
    public void processingInstruction(String target, String data) {
    }

    @Override
    public void skippedEntity(String name) {
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.print(localName);
    }

    @Override
    public void endDocument() {
        System.out.println("\nParsing ended");
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
    }

    @Override
    public void endPrefixMapping(String prefix) {
    }
}

