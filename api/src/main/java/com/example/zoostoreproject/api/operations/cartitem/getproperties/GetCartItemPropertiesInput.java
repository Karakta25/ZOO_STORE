package com.example.zoostoreproject.api.operations.cartitem.getproperties;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCartItemPropertiesInput implements OperationInput {

    List<UUID> itemsId;
}
