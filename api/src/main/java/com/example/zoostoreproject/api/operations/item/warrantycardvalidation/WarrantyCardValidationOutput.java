package com.example.zoostoreproject.api.operations.item.warrantycardvalidation;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarrantyCardValidationOutput implements OperationResult {

    private String operation;
    private Integer warrantyPeriod;
    private boolean success;
}
