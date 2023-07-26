package com.example.zoostoreproject.api.operations.item.editItemProperties;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Optional;

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
