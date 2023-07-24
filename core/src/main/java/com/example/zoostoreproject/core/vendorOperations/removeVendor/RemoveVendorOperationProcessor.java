package com.example.zoostoreproject.core.vendorOperations.removeVendor;

import com.example.zoostoreproject.api.operations.vendor.removeVendor.RemoveVendorInput;
import com.example.zoostoreproject.api.operations.vendor.removeVendor.RemoveVendorOutput;
import com.example.zoostoreproject.api.operations.vendor.removeVendor.RemoveVendorOperation;
import com.example.zoostoreproject.core.exception.vendor.NoSuchVendorException;
import com.example.zoostoreproject.core.exception.vendor.VendorCannotBeDeletedException;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemoveVendorOperationProcessor implements RemoveVendorOperation {

    private final VendorRepository vendorRepository;

    @Override
    public RemoveVendorOutput process(RemoveVendorInput input)  {
        Optional<Vendor> vendorOptional  = vendorRepository.findById(UUID.fromString(input.getId()));
        if(!vendorOptional.isPresent())
            throw new NoSuchVendorException();

        Vendor vendor = vendorOptional.get();

        if(!vendor.getItems().isEmpty())
            throw new VendorCannotBeDeletedException();

        vendorRepository.delete(vendor);

        return RemoveVendorOutput.builder()
                .id(input.getId())
                .build();

    }

}

