package com.example.zoostoreproject.core.itemOperations.createItem;


import com.example.zoostoreproject.api.operations.item.createItem.CreateItemInput;
import com.example.zoostoreproject.api.operations.item.createItem.CreateItemOutput;
import com.example.zoostoreproject.api.operations.item.createItem.CreateItemOperation;
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
public class CreateItemOperationProcessor implements CreateItemOperation {

    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;



    @Override
    public CreateItemOutput process(CreateItemInput input) {

        Optional<Vendor> optionalVendor = vendorRepository.findById(UUID.fromString(input.getVendorID()));
        Vendor vendor = optionalVendor.get();

        Item item = Item.builder()
                .productName(input.getProductName())
                .description(input.getDescription())
                .vendor(vendor)
                .build();

        itemRepository.save(item);

        return CreateItemOutput.builder()
                .itemID(item.getId().toString())
                .build();

    }
}