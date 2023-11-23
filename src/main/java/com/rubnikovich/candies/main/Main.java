package com.rubnikovich.candies.main;

import com.rubnikovich.candies.exception.CustomException;
import com.rubnikovich.candies.parser.ParserDOM;
import com.rubnikovich.candies.parser.CustomSAX;
import com.rubnikovich.candies.validator.ValidatorSaxXsd;

public class Main {
    public static void main(String[] args) throws CustomException {
        ParserDOM parser = new ParserDOM();
        parser.buildCandiesSet();
//        parser.getCandies().forEach(System.out::println);
        ValidatorSaxXsd.validate();

        CustomSAX parserSAX = new CustomSAX();
        parserSAX.customParseSAX();





    }
}
