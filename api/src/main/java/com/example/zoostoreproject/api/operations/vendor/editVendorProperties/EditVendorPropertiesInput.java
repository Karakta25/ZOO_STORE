package com.example.zoostoreproject.api.operations.vendor.editVendorProperties;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
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
