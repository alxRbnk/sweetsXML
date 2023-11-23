package com.rubnikovich.candies.validator;

import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.rubnikovich.candies.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

public class ValidatorSaxXsd {
    public static final String FILE_NAME = "files/candies.xml";
    public static final String SCHEMA_NAME = "files/candies.xsd";
    public static final Logger logger = LogManager.getLogger();

    public static void validate() throws CustomException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = factory.newSchema(new File(SCHEMA_NAME));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(FILE_NAME);
            validator.validate(source);
            logger.info(FILE_NAME + " is valid.");
        } catch (SAXException e) {
            throw new CustomException("validation " + FILE_NAME
                    + " is not valid because " + e.getMessage());

        } catch (IOException e) {
            throw new CustomException(FILE_NAME + " is not valid because "
                    + e.getMessage());
        }
    }
}
