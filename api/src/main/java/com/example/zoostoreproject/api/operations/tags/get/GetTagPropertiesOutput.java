package com.example.zoostoreproject.api.operations.tags.get;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetTagPropertiesOutput implements OperationResult {
    private String tagId;
    private String title;
}
