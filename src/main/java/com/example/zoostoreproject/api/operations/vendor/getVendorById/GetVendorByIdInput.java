package com.example.zoostoreproject.api.operations.vendor.getVendorById;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVendorByIdInput implements OperationInput {

    private String id;
}
