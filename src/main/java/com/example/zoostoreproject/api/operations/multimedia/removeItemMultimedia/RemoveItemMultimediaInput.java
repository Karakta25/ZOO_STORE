package com.example.zoostoreproject.api.operations.multimedia.removeItemMultimedia;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveItemMultimediaInput implements OperationInput {

    private String multimediaID;
}
