package com.example.zoostoreproject.api.operations.tags.removeItemTags;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveItemTagsOutput implements OperationResult {

    private String tagID;
}
