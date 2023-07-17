package com.example.zoostoreproject.api.operations.vendor.editVendorName;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorNameInput implements OperationInput {

    private String vendorId;
    private String name;
}
