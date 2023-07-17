package com.example.zoostoreproject.api.operations.item.editItemProductName;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditProductNameInput implements OperationInput {

    private String itemID;
    private String title;
    private String description;

}
