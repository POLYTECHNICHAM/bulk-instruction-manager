package com.bnpp.bulkinstructionmanager.controllers;

import com.bnpp.bulkinstructionmanager.payload.Acknowledgment;
import com.bnpp.bulkinstructionmanager.payload.BulkRequestBody;
import com.bnpp.bulkinstructionmanager.payload.ErrorResponse;
import com.bnpp.bulkinstructionmanager.service.TransactionFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

@RestController
public class BulkNotification {

    @PostMapping("/bulk-notification")
    public ResponseEntity<?> postBulkNotification(@RequestBody BulkRequestBody bulkRequestBody) throws SAXException {
        TransactionFile transactionFile = new TransactionFile(bulkRequestBody.getTransactionFileName(),
                bulkRequestBody.getTransactionFilePath());

        if(transactionFile.validateTransactionDocument()){
            Acknowledgment acknowledgment = new Acknowledgment(bulkRequestBody.getTransactionFilePath());
            return new ResponseEntity<>(acknowledgment, HttpStatus.ACCEPTED);
        }
        else{
            ErrorResponse errorResponse = new ErrorResponse(bulkRequestBody.getTransactionFilePath(),"The transaction file is not valid");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
