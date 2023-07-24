package com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddItemMultimediaInput implements OperationInput {

    @NotBlank(message = "URL must not be blank!")
    private String url;
    @NotBlank(message = "Item id must not be blank!")
    private String itemID;
}
