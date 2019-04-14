package com.bnpp.bulkinstructionmanager.payload;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BulkRequestBody {
    private String transactionFileName;
    private String transactionFilePath;
}
