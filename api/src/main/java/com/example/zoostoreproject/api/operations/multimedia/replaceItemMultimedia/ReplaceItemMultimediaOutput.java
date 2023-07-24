package com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplaceItemMultimediaOutput implements OperationResult {

    private String multimediaID;
    private String updateUrl;
}
