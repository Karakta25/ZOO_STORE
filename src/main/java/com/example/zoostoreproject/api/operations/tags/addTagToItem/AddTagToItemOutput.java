package com.example.zoostoreproject.api.operations.tags.addTagToItem;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.persistence.entities.Tag;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTagToItemOutput implements OperationResult {

    private String itemId;
    private Tag tagId;
}
