package com.example.zoostoreproject.api.operations.item.editItemProductName;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditProductNameInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String itemID;
    @NotBlank(message = "Product name must not be blank!")
    private String productName;


}
