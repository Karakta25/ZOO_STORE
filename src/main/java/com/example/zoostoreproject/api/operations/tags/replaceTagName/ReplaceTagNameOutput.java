package com.example.zoostoreproject.api.operations.tags.replaceTagName;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplaceTagNameOutput implements OperationResult {

    private String tagID;
    private String title;
}
