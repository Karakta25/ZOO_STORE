package com.example.zoostoreproject.api.operations.item.getItemByDescription;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemByDescriptionInput implements OperationInput {

    @NotBlank(message = "Tag title must not be blank!")
    private String regex;

    private Integer itemCount;
    private Integer page;
}
