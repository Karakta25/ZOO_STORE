package com.example.zoostoreproject.api.operations.tags.addTag;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTagInput implements OperationInput {

    @NotBlank(message = "Title must not be blank!")
    private String title;
}
