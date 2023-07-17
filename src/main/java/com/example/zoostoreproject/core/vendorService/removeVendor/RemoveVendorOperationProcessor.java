package com.example.zoostoreproject.core.vendorService.removeVendor;

import com.example.zoostoreproject.api.operations.vendor.removeVendor.RemoveVendorInput;
import com.example.zoostoreproject.api.operations.vendor.removeVendor.RemoveVendorOutput;
import com.example.zoostoreproject.api.operations.vendor.removeVendor.RemoveVendorOperation;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import com.example.zoostoreproject.core.exception.WrongDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemoveVendorOperationProcessor implements RemoveVendorOperation {

    private final VendorRepository vendorRepository;

    @Override
    public RemoveVendorOutput process(RemoveVendorInput input) throws WrongDataException {
        Optional<Vendor> optionalVendor = vendorRepository.findById(UUID.fromString(input.getId()));

        Vendor vendor = optionalVendor.get();
        if(!vendor.getItems().isEmpty())
            throw new WrongDataException("THE VENDOR CANNOT BE DELETED");

        vendorRepository.delete(vendor);

        return RemoveVendorOutput.builder()
                .id(input.getId())
                .build();

    }

}

