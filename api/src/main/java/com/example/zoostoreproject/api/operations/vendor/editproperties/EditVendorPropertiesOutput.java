package com.example.zoostoreproject.api.operations.vendor.editproperties;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorPropertiesOutput implements OperationResult {

    private String vendorId;
    private String name;
    private String phone;
}
