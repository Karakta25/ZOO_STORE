package com.example.zoostoreproject.api.operations.item.getAllItems;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.api.operations.item.GetItemPropertiesOutput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllItemsListOutput implements OperationResult {

    private List<GetItemPropertiesOutput> itemslist;
}
