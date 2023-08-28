package com.example.zoostoreproject.api.operations.item.editproperties;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditItemPropertiesInput implements OperationInput {


    private String itemID;
    private String description;
    private String productName;
    private String vendorId;
}
