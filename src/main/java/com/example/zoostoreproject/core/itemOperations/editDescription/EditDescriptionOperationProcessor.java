package com.example.zoostoreproject.core.itemOperations.editDescription;



import com.example.zoostoreproject.api.operations.item.editItemDescription.EditDescriptionInput;
import com.example.zoostoreproject.api.operations.item.editItemDescription.EditDescriptionOperation;
import com.example.zoostoreproject.api.operations.item.editItemDescription.EditDescriptionOutput;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditDescriptionOperationProcessor implements EditDescriptionOperation {
    @Override
    public EditDescriptionOutput process(EditDescriptionInput input) {
        return null;
    }
}
