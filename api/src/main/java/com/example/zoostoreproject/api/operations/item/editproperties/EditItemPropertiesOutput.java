package com.example.zoostoreproject.api.operations.item.editproperties;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditItemPropertiesOutput implements OperationResult {

    private String itemId;
    private String description;
    private String productName;
    private String vendorId;
}
