package com.example.zoostoreproject.api.operations.item.editItemDescription;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditDescriptionOutput implements OperationResult {

    private String itemId;
    private String description;
}
