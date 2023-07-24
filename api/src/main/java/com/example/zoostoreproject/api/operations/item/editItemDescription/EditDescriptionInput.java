package com.example.zoostoreproject.api.operations.item.editItemDescription;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditDescriptionInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String itemId;
    @NotBlank(message = "Description must not be blank!")
    private String description;
}
