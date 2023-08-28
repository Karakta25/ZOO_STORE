package com.example.zoostoreproject.api.operations.item.get.bydescription;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemByDescriptionInput implements OperationInput {

    @NotBlank(message = "Description must not be blank!")
    private String regex;
    private Integer itemCount;
    private Integer page;
}
