package com.example.zoostoreproject.api.operations.multimedia.getMultimediaById;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMultimediaByIdInput implements OperationInput {

    @NotBlank(message = "Media id must not be blank!")
    private String mediaID;
}
