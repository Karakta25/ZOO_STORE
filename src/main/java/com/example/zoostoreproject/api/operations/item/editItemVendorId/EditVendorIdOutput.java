package com.example.zoostoreproject.api.operations.item.editItemVendorId;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorIdOutput implements OperationResult {

    private String itemId;
    private String vendorId;
}
