package com.example.zoostoreproject.api.operations.tags.get.bytitle;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemTagByTitleInput implements OperationInput {

    @NotBlank(message = "Tag title must not be blank!")
    private String tagTitle;
}
