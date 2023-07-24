package com.example.zoostoreproject.api.operations.item.editItemVendorId;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorIdInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String itemId;
    @NotBlank(message = "Vendor id must not be blank!")
    private String vendorId; // existing vendor id from database
}
