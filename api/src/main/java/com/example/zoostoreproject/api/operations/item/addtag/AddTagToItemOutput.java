package com.example.zoostoreproject.api.operations.item.addtag;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTagToItemOutput implements OperationResult {

    private String itemId;
    private String title;
}
