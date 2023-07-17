package com.example.zoostoreproject.core.itemOperations.editVendorId;


import com.example.zoostoreproject.api.operations.item.editItemVendorId.EditVendorIdInput;
import com.example.zoostoreproject.api.operations.item.editItemVendorId.EditVendorIdOutput;
import com.example.zoostoreproject.api.operations.item.editItemVendorId.EditVendorIdOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditVendorIdOperationProcessor implements EditVendorIdOperation {
    @Override
    public EditVendorIdOutput process(EditVendorIdInput input) {
        return null;
    }
}
