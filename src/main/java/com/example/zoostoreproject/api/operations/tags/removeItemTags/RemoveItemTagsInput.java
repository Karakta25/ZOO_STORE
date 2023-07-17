package com.example.zoostoreproject.api.operations.tags.removeItemTags;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveItemTagsInput implements OperationInput {

    private String tagID;
}
