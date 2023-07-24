package com.example.zoostoreproject.core.itemOperations.editProductName;


import com.example.zoostoreproject.api.operations.item.editItemDescription.EditDescriptionOutput;
import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameInput;
import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameOutput;
import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameOperation;
import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditProductNameOperationProcessor implements EditProductNameOperation {

    private final ItemRepository itemRepository;

    @Override
    public EditProductNameOutput process(EditProductNameInput input) {


        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemID()));

        if(!optionalItem.isPresent())
            throw new NoSuchItemException();

        Item item = optionalItem.get();

        item.setProductName(input.getProductName());

        itemRepository.save(item);

        return EditProductNameOutput.builder()
                .itemID(item.getId().toString())
                .productName(item.getDescription())
                .build();
    }
}
