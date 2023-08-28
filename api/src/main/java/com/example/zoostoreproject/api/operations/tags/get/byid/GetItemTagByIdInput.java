package com.example.zoostoreproject.api.operations.tags.get.byid;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemTagByIdInput implements OperationInput {

    @NotBlank(message = "Tag id must not be blank!")
    private String tagID;
}
