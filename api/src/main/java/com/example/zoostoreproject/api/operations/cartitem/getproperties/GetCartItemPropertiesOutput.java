package com.example.zoostoreproject.api.operations.cartitem.getproperties;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.api.operations.item.get.GetItemPropertiesOutput;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCartItemPropertiesOutput implements OperationResult {

    List<GetItemPropertiesOutput> itemsList;
}
