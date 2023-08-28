package com.example.zoostoreproject.api.operations.item.create;
import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemInput implements OperationInput {

    @NotBlank(message = "Product name must not be blank!")
    private String productName;
    @NotBlank(message = "Description must not be blank!")
    private String description;
    @NotBlank(message = "Vendor id must not be blank!")
    private String vendorID;
    @Min(0)
    @Max(24)
    private int warrantyPeriod;
}
