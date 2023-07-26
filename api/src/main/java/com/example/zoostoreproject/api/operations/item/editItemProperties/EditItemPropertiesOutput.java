package com.example.zoostoreproject.api.operations.item.editItemProperties;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import jakarta.validation.constraints.NotBlank;
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
