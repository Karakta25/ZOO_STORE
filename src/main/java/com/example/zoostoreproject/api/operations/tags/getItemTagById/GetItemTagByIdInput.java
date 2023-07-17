package com.example.zoostoreproject.api.operations.tags.getItemTagById;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemTagByIdInput implements OperationInput {

    private String tagId;
}
