package com.example.zoostoreproject.api.operations.vendor.remove;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveVendorInput implements OperationInput {


    @NotBlank(message = "Vendor id must not be blank!")
    private String id;
}
