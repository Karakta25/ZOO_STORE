package com.example.zoostoreproject.core.vendorService.editVendorName;

import com.example.zoostoreproject.api.operations.vendor.editVendorName.EditVendorNameInput;
import com.example.zoostoreproject.api.operations.vendor.editVendorName.EditVendorNameOutput;
import com.example.zoostoreproject.api.operations.vendor.editVendorName.EditVendorNameOperation;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditVendorNameOperationProcessor implements EditVendorNameOperation {

    private final VendorRepository vendorRepository;

    @Override
    public EditVendorNameOutput process(EditVendorNameInput input) {
        return null;
    }
}
