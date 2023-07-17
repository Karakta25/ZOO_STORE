package com.example.zoostoreproject.api.operations.vendor.removeVendor;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveVendorInput implements OperationInput {

    private String id;
}
