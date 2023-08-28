package com.example.zoostoreproject.api.operations.vendor.get.allvendors;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.api.operations.vendor.get.GetVendorPropertiesOutput;
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
