package com.example.zoostoreproject.core.vendorService.editVendorPhone;

import com.example.zoostoreproject.api.operations.vendor.editVendorPhone.EditVendorPhoneInput;
import com.example.zoostoreproject.api.operations.vendor.editVendorPhone.EditVendorPhoneOutput;
import com.example.zoostoreproject.api.operations.vendor.editVendorPhone.EditVendorPhoneOperation;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditVendorPhoneOperationProcessor implements EditVendorPhoneOperation {

    private final VendorRepository vendorRepository;
    @Override
    public EditVendorPhoneOutput process(EditVendorPhoneInput input) {
        return null;
    }


}
