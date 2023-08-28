package com.example.zoostoreproject.api.operations.vendor.get.byid;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.api.operations.item.get.GetItemPropertiesOutput;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVendorByIdOutput implements OperationResult {
    private String id;
    private String name;
    private String phone;
    private Set<GetItemPropertiesOutput> items;

}
