package com.example.zoostoreproject.api.operations.item.removeTagFromItem;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveTagFromItemInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String itemId;
    @NotBlank(message = "Title must not be blank!")
    private String title;
}
