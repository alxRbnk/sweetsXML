package com.rubnikovich.candies.jaxb;

import com.rubnikovich.candies.exception.CustomException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class JaxbParser {

    public static void main(String[] args) throws CustomException {
        try {
            JAXBContext context = JAXBContext.newInstance(JaxbCandies.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader = new FileReader("files/candies.xml");
            JaxbCandies candies = (JaxbCandies) unmarshaller.unmarshal(reader);
            System.out.println(candies);
        } catch (JAXBException | FileNotFoundException e) {
            throw new CustomException(e);
        }
    }
}


