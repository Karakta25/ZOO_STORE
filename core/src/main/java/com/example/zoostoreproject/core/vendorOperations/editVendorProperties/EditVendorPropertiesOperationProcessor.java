package com.example.zoostoreproject.core.vendorOperations.editVendorProperties;

import com.example.zoostoreproject.api.operations.vendor.editVendorProperties.EditVendorPropertiesInput;
import com.example.zoostoreproject.api.operations.vendor.editVendorProperties.EditVendorPropertiesOutput;
import com.example.zoostoreproject.api.operations.vendor.editVendorProperties.EditVendorPropertiesOperation;
import com.example.zoostoreproject.core.exception.vendor.NoSuchVendorException;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
