package com.example.zoostoreproject.api.operations.item.archive;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ArchiveItemInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String itemID;

    @NotNull(message = "Item archived status must not be blank!")
    private Boolean archived;
}
