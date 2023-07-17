package com.example.zoostoreproject.api.operations.tags.addTag;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTagOutput implements OperationResult {
    private String tagID;

}
