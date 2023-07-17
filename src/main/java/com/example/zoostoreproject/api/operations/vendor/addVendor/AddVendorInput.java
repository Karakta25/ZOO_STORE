package com.example.zoostoreproject.api.operations.vendor.addVendor;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddVendorInput implements OperationInput {
    private String name;
    private String phone;

}
