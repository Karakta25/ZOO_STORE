package com.example.zoostoreproject.core.vendor.editproperties;

import com.example.zoostoreproject.api.operations.vendor.editproperties.EditVendorPropertiesInput;
import com.example.zoostoreproject.api.operations.vendor.editproperties.EditVendorPropertiesOutput;
import com.example.zoostoreproject.api.operations.vendor.editproperties.EditVendorPropertiesOperation;
import com.example.zoostoreproject.core.exception.vendor.NoSuchVendorException;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditVendorPropertiesOperationProcessor implements EditVendorPropertiesOperation {

    private final VendorRepository vendorRepository;

    @Override
    public EditVendorPropertiesOutput process(EditVendorPropertiesInput input) {

            Vendor vendor = vendorRepository.findById(UUID.fromString(input.getVendorId()))
                    .orElseThrow(NoSuchVendorException::new);

            if(!input.getName().isBlank())
                vendor.setName(input.getName());
            if(!input.getPhone().isBlank())
                vendor.setPhone(input.getPhone());

            vendorRepository.save(vendor);

            return  EditVendorPropertiesOutput.builder()
                    .vendorId(vendor.getId().toString())
                    .name(vendor.getName())
                    .build();
        }
}
