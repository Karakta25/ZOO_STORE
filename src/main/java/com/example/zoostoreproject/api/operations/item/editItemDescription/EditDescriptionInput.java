package com.example.zoostoreproject.api.operations.item.editItemDescription;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditDescriptionInput implements OperationInput {


    private String itemId;
    private String description;
}
