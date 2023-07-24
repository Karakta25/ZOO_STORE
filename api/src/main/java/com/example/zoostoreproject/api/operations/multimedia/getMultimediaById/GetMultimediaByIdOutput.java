package com.example.zoostoreproject.api.operations.multimedia.getMultimediaById;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMultimediaByIdOutput implements OperationResult {

    private String mediaID;
    private String url;
    private String itemID;
}
