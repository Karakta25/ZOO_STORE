package com.example.zoostoreproject.core.vendor.add;

import com.example.zoostoreproject.api.operations.vendor.add.AddVendorInput;
import com.example.zoostoreproject.api.operations.vendor.add.AddVendorOutput;
import com.example.zoostoreproject.api.operations.vendor.add.AddVendorOperation;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddVendorOperationProcessor implements AddVendorOperation {

    private final VendorRepository vendorRepository;

    @Override
    public AddVendorOutput process(AddVendorInput input) {
        Vendor vendor = Vendor.builder()
                .name(input.getName())
                .phone(input.getPhone())
                .build();

        vendorRepository.save(vendor);

        return AddVendorOutput.builder()
                .id(vendor.getId().toString())
                .build();
    }
}
