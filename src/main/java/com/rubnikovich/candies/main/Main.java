package com.rubnikovich.candies.main;

import com.rubnikovich.candies.parser.*;
import com.rubnikovich.candies.parser.jaxb.Candies;
import com.rubnikovich.candies.exception.CustomException;
import com.rubnikovich.candies.validator.ValidatorSaxXsd;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws CustomException {
        ValidatorSaxXsd.validate();

//        ParserDOM parser = new ParserDOM();
//        parser.buildCandiesSet();
//        parser.getCandies().forEach(System.out::println);

//        CandySaxBuilder saxBuilder = new CandySaxBuilder();
//        saxBuilder.buildSetCandies("files/candies.xml");
//        saxBuilder.getCandies().forEach(System.out::println);

//        StaxBuilder staxBuilder = new StaxBuilder();
//        staxBuilder.buildSetCandies("files/candies.xml");
//        staxBuilder.getCandies().forEach(System.out::println);

//        FlagSAX customSAX = new FlagSAX();
//        customSAX.customParseSAX();
//        FlagHandler.getInstance().getCandies().forEach(System.out::println);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Candies.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader("files/candiesJaxb.xml");
            Candies candies = (Candies) unmarshaller.unmarshal(reader);
            candies.getCandies().forEach(System.out::println);
        } catch (JAXBException | FileNotFoundException exception) {
            throw new CustomException(exception);
        }
    }
}
