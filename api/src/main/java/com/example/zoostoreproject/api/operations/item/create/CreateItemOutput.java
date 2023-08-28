package com.example.zoostoreproject.api.operations.item.create;

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
