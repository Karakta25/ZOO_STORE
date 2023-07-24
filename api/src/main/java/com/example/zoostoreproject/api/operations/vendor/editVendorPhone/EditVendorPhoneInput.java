package com.example.zoostoreproject.api.operations.vendor.editVendorPhone;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorPhoneInput implements OperationInput {


    @NotBlank(message = "Vendor id must not be blank!")
    private String vendorId;

    @NotBlank(message = "Phone must not be blank!")
    private String phone;
}
