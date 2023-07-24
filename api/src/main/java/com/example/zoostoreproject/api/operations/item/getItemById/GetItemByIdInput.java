package com.example.zoostoreproject.api.operations.item.getItemById;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemByIdInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String id;
}
