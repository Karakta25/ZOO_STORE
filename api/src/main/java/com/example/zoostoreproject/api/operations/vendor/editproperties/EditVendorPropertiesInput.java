package com.example.zoostoreproject.api.operations.vendor.editproperties;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorPropertiesInput implements OperationInput {

    private String vendorId;
    private String name;
    private String phone;
}
