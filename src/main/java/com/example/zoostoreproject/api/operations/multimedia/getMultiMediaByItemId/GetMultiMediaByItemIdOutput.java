package com.example.zoostoreproject.api.operations.multimedia.getMultiMediaByItemId;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMultiMediaByItemIdOutput implements OperationResult {

    private Set<String> mediaID;
    private Set<String> url;
}
