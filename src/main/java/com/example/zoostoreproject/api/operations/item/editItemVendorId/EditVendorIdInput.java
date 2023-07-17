package com.example.zoostoreproject.api.operations.item.editItemVendorId;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorIdInput implements OperationInput {

    private String itemId;
    private String vendorId;
}
