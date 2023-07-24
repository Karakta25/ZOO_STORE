package com.example.zoostoreproject.api.operations.tags.removeItemTags;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveItemTagsInput implements OperationInput {

    @NotBlank(message = "Tag id must not be blank!")
    private String tagID;
}
