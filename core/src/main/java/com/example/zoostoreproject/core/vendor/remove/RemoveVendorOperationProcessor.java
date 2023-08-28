package com.example.zoostoreproject.core.vendor.remove;

import com.example.zoostoreproject.api.operations.vendor.remove.RemoveVendorInput;
import com.example.zoostoreproject.api.operations.vendor.remove.RemoveVendorOutput;
import com.example.zoostoreproject.api.operations.vendor.remove.RemoveVendorOperation;
import com.example.zoostoreproject.core.exception.vendor.NoSuchVendorException;
import com.example.zoostoreproject.core.exception.vendor.VendorCannotBeDeletedException;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemoveVendorOperationProcessor implements RemoveVendorOperation {

    private final VendorRepository vendorRepository;

    @Override
    public RemoveVendorOutput process(RemoveVendorInput input)  {

        Vendor vendor = vendorRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(NoSuchVendorException::new);

        if(!vendor.getItems().isEmpty())
            throw new VendorCannotBeDeletedException();

        vendorRepository.delete(vendor);

        return RemoveVendorOutput.builder()
                .id(input.getId())
                .build();

    }

}

