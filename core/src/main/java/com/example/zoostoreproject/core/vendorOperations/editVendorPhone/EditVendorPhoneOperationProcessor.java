package com.example.zoostoreproject.core.vendorOperations.editVendorPhone;

import com.example.zoostoreproject.api.operations.vendor.editVendorName.EditVendorNameInput;
import com.example.zoostoreproject.api.operations.vendor.editVendorName.EditVendorNameOutput;
import com.example.zoostoreproject.api.operations.vendor.editVendorPhone.EditVendorPhoneInput;
import com.example.zoostoreproject.api.operations.vendor.editVendorPhone.EditVendorPhoneOutput;
import com.example.zoostoreproject.api.operations.vendor.editVendorPhone.EditVendorPhoneOperation;
import com.example.zoostoreproject.core.exception.vendor.NoSuchVendorException;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditVendorPhoneOperationProcessor implements EditVendorPhoneOperation {

    private final VendorRepository vendorRepository;

    @Override
    public EditVendorPhoneOutput process(EditVendorPhoneInput input) {

        Optional<Vendor> vendorOptional = vendorRepository.findById(UUID.fromString(input.getVendorId()));
        if(!vendorOptional.isPresent())
            throw new NoSuchVendorException();

        Vendor vendor = vendorOptional.get();

        vendor.setPhone(input.getPhone());

        vendorRepository.save(vendor);

        return EditVendorPhoneOutput.builder()
                .vendorId(vendor.getId().toString())
                .phone(vendor.getPhone())
                .build();
    }
}
