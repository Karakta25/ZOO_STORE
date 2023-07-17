package com.example.zoostoreproject.api.operations.item.createItem;
import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemInput implements OperationInput {

    private String productName;
    private String description;
    private String vendorID;

}
