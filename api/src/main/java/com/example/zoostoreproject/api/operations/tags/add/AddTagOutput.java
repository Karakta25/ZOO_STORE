package com.example.zoostoreproject.api.operations.tags.add;

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
