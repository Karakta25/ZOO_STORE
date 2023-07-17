package com.example.zoostoreproject.api.operations.tags.addTag;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTagInput implements OperationInput {
    private String title;
}
