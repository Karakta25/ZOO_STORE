package com.example.zoostoreproject.core.itemOperations.editDescription;



import com.example.zoostoreproject.api.operations.item.editItemDescription.EditDescriptionInput;
import com.example.zoostoreproject.api.operations.item.editItemDescription.EditDescriptionOperation;
import com.example.zoostoreproject.api.operations.item.editItemDescription.EditDescriptionOutput;

import com.example.zoostoreproject.api.operations.vendor.editVendorPhone.EditVendorPhoneOutput;
import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditDescriptionOperationProcessor implements EditDescriptionOperation {

    private final ItemRepository itemRepository;
    @Override
    public EditDescriptionOutput process(EditDescriptionInput input) {


        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemId()));

        if(!optionalItem.isPresent())
            throw new NoSuchItemException();

        Item item = optionalItem.get();

        item.setDescription(input.getDescription());

        itemRepository.save(item);

        return EditDescriptionOutput.builder()
                .itemId(item.getId().toString())
                .description(item.getDescription())
                .build();
    }
}
