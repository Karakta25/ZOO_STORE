package com.example.zoostoreproject.api.operations.vendor.editVendorName;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorNameOutput implements OperationResult {

    private String vendorId;
    private String name;
}
