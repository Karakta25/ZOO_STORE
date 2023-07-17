package com.example.zoostoreproject.api.operations.item.editItemProductName;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditProductNameOutput implements OperationResult {

    private String itemID;
}
