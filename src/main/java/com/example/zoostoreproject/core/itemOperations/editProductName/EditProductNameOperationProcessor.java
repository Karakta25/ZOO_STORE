package com.example.zoostoreproject.core.itemOperations.editProductName;


import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameInput;
import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameOutput;
import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditProductNameOperationProcessor implements EditProductNameOperation {
    @Override
    public EditProductNameOutput process(EditProductNameInput input) {
        return null;
    }
}
