package com.example.zoostoreproject.api.operations.vendor.remove;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveVendorOutput implements OperationResult {
    private String id;
}
