package com.example.zoostoreproject.api.operations.item.createItem;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemOutput implements OperationResult {

    private String itemID;

}
