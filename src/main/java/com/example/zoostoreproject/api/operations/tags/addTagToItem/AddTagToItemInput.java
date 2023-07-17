package com.example.zoostoreproject.api.operations.tags.addTagToItem;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import com.example.zoostoreproject.persistence.entities.Tag;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTagToItemInput implements OperationInput {

    private String itemId;
    private Tag tagId;
}
