package com.example.zoostoreproject.api.operations.vendor.getAllVendors;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.api.operations.vendor.GetVendorPropertiesOutput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllVendorsOutput implements OperationResult {

    List<GetVendorPropertiesOutput> vendorslist;

}
