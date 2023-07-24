package com.example.zoostoreproject.api.operations.tags.replaceTagName;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplaceTagNameInput implements OperationInput {
    @NotBlank(message = "Tag id must not be blank!")
    private String tagID;
    @NotBlank(message = "Title must not be blank!")
    private String title; //new title
}
