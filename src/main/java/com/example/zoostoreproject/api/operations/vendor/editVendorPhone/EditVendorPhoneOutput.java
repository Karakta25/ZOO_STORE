package com.example.zoostoreproject.api.operations.vendor.editVendorPhone;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorPhoneOutput implements OperationResult {

    private String vendorId;
    private String phone;
}
