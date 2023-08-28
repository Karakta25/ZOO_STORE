package com.example.zoostoreproject.api.operations.tags.get.bytitle;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemTagByTitleOutput implements OperationResult {

    private String tagId;
}
