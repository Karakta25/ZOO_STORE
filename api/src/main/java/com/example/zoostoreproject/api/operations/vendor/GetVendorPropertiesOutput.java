package com.example.zoostoreproject.api.operations.vendor;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.api.operations.item.GetItemPropertiesOutput;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVendorPropertiesOutput implements OperationResult {

    private String id;
    private String name;
    private String phone;
    private Set<GetItemPropertiesOutput> items;
}
