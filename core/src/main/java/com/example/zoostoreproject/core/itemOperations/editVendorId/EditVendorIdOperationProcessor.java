package com.example.zoostoreproject.core.itemOperations.editVendorId;


import com.example.zoostoreproject.api.operations.item.editItemVendorId.EditVendorIdInput;
import com.example.zoostoreproject.api.operations.item.editItemVendorId.EditVendorIdOutput;
import com.example.zoostoreproject.api.operations.item.editItemVendorId.EditVendorIdOperation;
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
public class EditVendorIdOperationProcessor implements EditVendorIdOperation {

    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;
    @Override
    public EditVendorIdOutput process(EditVendorIdInput input) {


        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemId()));
        if(!optionalItem.isPresent())
            throw new NoSuchItemException();

        Optional<Vendor> vendorOptional = vendorRepository.findById(UUID.fromString(input.getVendorId()));
        if(!vendorOptional.isPresent())
            throw new NoSuchVendorException();

        Item item = optionalItem.get();
        Vendor vendor = vendorOptional.get();


        item.setVendor(vendor);

        itemRepository.save(item);
        return EditVendorIdOutput.builder()
                .itemId(item.getId().toString())
                .vendorName(item.getVendor().getName())
                .build();
    }

}
