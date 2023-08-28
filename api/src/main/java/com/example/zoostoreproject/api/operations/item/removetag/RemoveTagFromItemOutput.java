package com.example.zoostoreproject.api.operations.item.removetag;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveTagFromItemOutput implements OperationResult {

    private String itemId;
    private String title;
}
