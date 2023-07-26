package com.example.zoostoreproject.core.itemOperations.editItemProperties;



import com.example.zoostoreproject.api.operations.item.editItemProperties.EditItemPropertiesInput;
import com.example.zoostoreproject.api.operations.item.editItemProperties.EditItemPropertiesOperation;
import com.example.zoostoreproject.api.operations.item.editItemProperties.EditItemPropertiesOutput;

import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
import com.example.zoostoreproject.core.exception.vendor.NoSuchVendorException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditItemPropertiesOperationProcessor implements EditItemPropertiesOperation {

    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;
    @Override
    public EditItemPropertiesOutput process(EditItemPropertiesInput input) {


        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemID()));
        if(!optionalItem.isPresent())
            throw new NoSuchItemException();

        Optional<Vendor> optionalVendor = vendorRepository.findById(UUID.fromString(input.getVendorId()));
        if(!optionalVendor.isPresent())
            throw new NoSuchVendorException();

        Item item = optionalItem.get();
        Vendor vendor = optionalVendor.get();

        if(!input.getDescription().isBlank())
            item.setDescription(input.getDescription());
        if(!input.getProductName().isBlank())
            item.setProductName(input.getProductName());

        item.setVendor(vendor);

        itemRepository.save(item);

        return EditItemPropertiesOutput.builder()
                .itemId(input.getItemID())
                .description(item.getDescription())
                .productName(item.getProductName())
                .vendorId(item.getVendor().getId().toString())
                .build();

    }
}
