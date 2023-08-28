package com.example.zoostoreproject.api.operations.multimedia.replace;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplaceItemMultimediaInput implements OperationInput {

    @NotBlank(message = "Media id must not be blank!")
    private String mediaID;
    @NotBlank(message = "URL must not be blank!")
    private String url; //new url
}
