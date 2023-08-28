package com.example.zoostoreproject.api.operations.item.get.allitems;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.api.operations.item.get.GetItemPropertiesOutput;
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
