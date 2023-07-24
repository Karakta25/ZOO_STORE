package com.example.zoostoreproject.core.vendorOperations.editVendorName;

import com.example.zoostoreproject.api.operations.tags.replaceTagName.ReplaceTagNameOutput;
import com.example.zoostoreproject.api.operations.vendor.editVendorName.EditVendorNameInput;
import com.example.zoostoreproject.api.operations.vendor.editVendorName.EditVendorNameOutput;
import com.example.zoostoreproject.api.operations.vendor.editVendorName.EditVendorNameOperation;
import com.example.zoostoreproject.core.exception.tag.NoSuchTagException;
import com.example.zoostoreproject.core.exception.vendor.NoSuchVendorException;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditVendorNameOperationProcessor implements EditVendorNameOperation {

    private final VendorRepository vendorRepository;

    @Override
    public EditVendorNameOutput process(EditVendorNameInput input) {

            Optional<Vendor> vendorOptional = vendorRepository.findById(UUID.fromString(input.getVendorId()));
            if(!vendorOptional.isPresent())
            throw new NoSuchVendorException();

            Vendor vendor = vendorOptional.get();

            vendor.setName(input.getName());

            vendorRepository.save(vendor);

            return  EditVendorNameOutput.builder()
                    .vendorId(vendor.getId().toString())
                    .name(vendor.getName())
                    .build();
        }
}
