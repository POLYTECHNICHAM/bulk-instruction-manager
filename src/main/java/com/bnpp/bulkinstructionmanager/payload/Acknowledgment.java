package com.bnpp.bulkinstructionmanager.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter@Setter
public class Acknowledgment {
    final private static String message ="The received transaction file is valid and will be processed";
    private UUID uid;
    private String transactionFilePath;

    public Acknowledgment(String transactionFilePath) {
        this.transactionFilePath = transactionFilePath;
        generateUUid();
    }

    private void generateUUid(){
        setUid(UUID.randomUUID());
    }
}
