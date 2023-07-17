package com.example.zoostoreproject.api.operations.tags.replaceTagName;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplaceTagNameInput implements OperationInput {

    private String tagID;
    private String title; //new title
}
