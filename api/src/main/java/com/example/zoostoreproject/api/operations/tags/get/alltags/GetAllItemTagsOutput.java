package com.example.zoostoreproject.api.operations.tags.get.alltags;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.api.operations.tags.get.GetTagPropertiesOutput;
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
