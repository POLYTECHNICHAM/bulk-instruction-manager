package com.bnpp.bulkinstructionmanager;

import com.bnpp.bulkinstructionmanager.service.TransactionFile;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestTransactionFile {
    private static TransactionFile transactionXmlFile;
    private static TransactionFile invalidTransactionXmlFile;
    private static TransactionFile NoTransactionXmlFile;

    @BeforeAll
    static void init(){

        transactionXmlFile = new TransactionFile();
        transactionXmlFile.setFileName("pain_001");
        transactionXmlFile.setXmlFilePath("C:\\Users\\Hicham\\IdeaProjects\\xmlparsing\\src\\test\\resources\\example.pain.001.xml");
        //transactionXmlFile.setXsdFilePath("C:\\Users\\Hicham\\IdeaProjects\\xmlparsing\\src\\test\\resources\\pain.001.001.03.xsd");

        invalidTransactionXmlFile = new TransactionFile();
        invalidTransactionXmlFile.setFileName("invalid_pain_001");
        invalidTransactionXmlFile.setXmlFilePath("C:\\Users\\Hicham\\IdeaProjects\\xmlparsing\\src\\test\\resources\\invalid.pain.001.xml");
        //invalidTransactionXmlFile.setXsdFilePath("C:\\Users\\Hicham\\IdeaProjects\\xmlparsing\\src\\test\\resources\\pain.001.001.03.xsd");

        NoTransactionXmlFile = new TransactionFile();
        NoTransactionXmlFile.setFileName("invalid_pain_001");
        NoTransactionXmlFile.setXmlFilePath("C:\\Users\\Hicham\\IdeaProjects\\xmlparsing\\src\\test\\resources\\pain.xml");
        //NoTransactionXmlFile.setXsdFilePath("C:\\Users\\Hicham\\IdeaProjects\\xmlparsing\\src\\test\\resources\\pain.001.001.03.xsd");

    }
    @Test
    void createTransactionDocumentShouldReturnDocumentObject() throws IOException, SAXException, ParserConfigurationException {
        assert (transactionXmlFile.createTransactionDocument() != null);
    }

    @Test
    void createTransactionDocumentShouldThrowFileNotFoundExceptionWhenXmlFileNotFound(){
        assertThrows(FileNotFoundException.class, NoTransactionXmlFile::createTransactionDocument);
    }

    @Test
    void validateTransactionDocumentShouldReturnTrueWhenXmlFileIsValid() throws SAXException {
        assertTrue(transactionXmlFile.validateTransactionDocument());
    }

    @Test
    void validateTransactionDocumentShouldReturnFalseWhenXmlFileIsInvalid() throws SAXException {
        assertFalse(invalidTransactionXmlFile.validateTransactionDocument());
    }

    @Test
    void validateTransactionDocumentShouldThrowFileNotFoundExceptionWhenXmlFileNotFound() throws SAXException {
        assertThrows(FileNotFoundException.class, NoTransactionXmlFile::createTransactionDocument);
    }

}
