package com.example.zoostoreproject.api.operations.vendor.addVendor;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddVendorInput implements OperationInput {

    @NotBlank(message = "Name must not be blank!")
    private String name;
    @NotBlank(message = "Phone must not be blank!")
    private String phone;

}
