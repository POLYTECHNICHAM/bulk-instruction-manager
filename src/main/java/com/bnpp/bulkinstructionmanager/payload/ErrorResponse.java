package com.bnpp.bulkinstructionmanager.payload;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ErrorResponse {
    String TransactionFilePath;
    String ErrorMessage;

    public ErrorResponse(String transactionFilePath, String errorMessage) {
        TransactionFilePath = transactionFilePath;
        ErrorMessage = errorMessage;
    }
}
