package com.rubnikovich.candies.main;

import com.rubnikovich.candies.exception.CustomException;
import com.rubnikovich.candies.parser.StaxBuilder;
import com.rubnikovich.candies.validator.ValidatorSaxXsd;

public class Main {
    public static void main(String[] args) throws CustomException {
        ValidatorSaxXsd.validate();

//        ParserDOM parser = new ParserDOM();
//        parser.buildCandiesSet();
//        parser.getCandies().forEach(System.out::println);

//        CandySaxBuilder saxBuilder = new CandySaxBuilder();
//        saxBuilder.buildSetCandies("files/candies.xml");
//        saxBuilder.getCandies().forEach(System.out::println);

        StaxBuilder staxBuilder = new StaxBuilder();
        staxBuilder.buildSetCandies("files/candies.xml");
        staxBuilder.getCandies().forEach(System.out::println);

    }
}
