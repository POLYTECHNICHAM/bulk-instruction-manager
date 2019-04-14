package com.bnpp.bulkinstructionmanager.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

@Getter@Setter
public class TransactionFile {

    private String fileName;
    private String XmlFilePath;
    final private static String xsdFilePath = "C:\\Users\\Hicham\\IdeaProjects\\bulk-instruction-manager\\src\\main\\resources\\static\\pain.001.001.03.xsd";

    public TransactionFile(){}

    public TransactionFile(String fileName, String XmlFilePath){
        this.fileName = fileName;
        this.XmlFilePath = XmlFilePath;
    }

    public Document createTransactionDocument() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document XmlDocument = builder.parse(new File(XmlFilePath));
        XmlDocument.getDocumentElement().normalize();
        return XmlDocument;
    }

    public Boolean validateTransactionDocument() throws SAXException {

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(xsdFilePath));
        Validator validator = schema.newValidator();
        try {
        validator.validate(new StreamSource(new File(XmlFilePath)));
        }catch (IOException | SAXException e) {
            return false;
        }
        return true;
    }

    //Boolean checkSum(){}
}
