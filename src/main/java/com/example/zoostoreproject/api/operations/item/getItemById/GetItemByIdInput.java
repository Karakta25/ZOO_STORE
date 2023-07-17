package com.example.zoostoreproject.api.operations.item.getItemById;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemByIdInput implements OperationInput {
    private String id;
}
