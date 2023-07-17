package com.example.zoostoreproject.api.operations.tags.getAllItemTags;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.api.operations.tags.GetTagPropertiesOutput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllItemTagsOutput implements OperationInput, OperationResult {

    List<GetTagPropertiesOutput> tagsList;
}
