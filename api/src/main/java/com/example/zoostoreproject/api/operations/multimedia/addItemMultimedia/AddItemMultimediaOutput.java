package com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddItemMultimediaOutput implements OperationResult {

    private String multimediaID;

}
