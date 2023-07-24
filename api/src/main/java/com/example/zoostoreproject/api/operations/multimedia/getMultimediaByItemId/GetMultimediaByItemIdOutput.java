package com.example.zoostoreproject.api.operations.multimedia.getMultimediaByItemId;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMultimediaByItemIdOutput implements OperationResult {

    private Set<String> mediaID;
    private Set<String> url;
}
