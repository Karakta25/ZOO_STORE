package com.example.zoostoreproject.api.operations.item.warrantycardvalidation;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarrantyCardValidationInput implements OperationInput {

    private String itemId;
    private String operation;
    private String feedback;


}
