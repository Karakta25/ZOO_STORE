package com.example.zoostoreproject.api.operations.vendor.editVendorName;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorNameInput implements OperationInput {

    @NotBlank(message = "Vendor id must not be blank!")
    private String vendorId;
    @NotBlank(message = "Name must not be blank!")
    private String name;
}
