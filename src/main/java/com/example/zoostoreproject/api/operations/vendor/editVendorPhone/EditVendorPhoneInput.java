package com.example.zoostoreproject.api.operations.vendor.editVendorPhone;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorPhoneInput implements OperationInput {

    private String vendorId;
    private String phone;
}
