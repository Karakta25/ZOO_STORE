package com.example.zoostoreproject.api.operations.multimedia.getMultiMediaByItemId;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMultiMediaByItemIdInput implements OperationInput {
    private String itemID;
}
