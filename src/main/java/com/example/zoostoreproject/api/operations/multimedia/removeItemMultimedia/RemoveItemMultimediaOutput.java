package com.example.zoostoreproject.api.operations.multimedia.removeItemMultimedia;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveItemMultimediaOutput implements OperationResult {

    private String multimediaID;
}
