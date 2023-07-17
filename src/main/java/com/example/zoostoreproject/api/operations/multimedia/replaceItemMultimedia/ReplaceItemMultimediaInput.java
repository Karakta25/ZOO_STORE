package com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplaceItemMultimediaInput implements OperationInput {

    private String multimediaID;
    private String url;           //new url
}
