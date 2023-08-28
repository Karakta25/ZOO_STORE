package com.example.zoostoreproject.api.operations.tags.get.byid;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemTagByIdOutput implements OperationResult {

    private String tagId;
    private String title;
}
