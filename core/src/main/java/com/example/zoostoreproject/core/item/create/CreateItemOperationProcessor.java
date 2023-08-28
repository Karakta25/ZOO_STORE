package com.example.zoostoreproject.core.item.create;


import com.example.zoostoreproject.api.operations.item.create.CreateItemInput;
import com.example.zoostoreproject.api.operations.item.create.CreateItemOutput;
import com.example.zoostoreproject.api.operations.item.create.CreateItemOperation;
import com.example.zoostoreproject.core.exception.vendor.NoSuchVendorException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateItemOperationProcessor implements CreateItemOperation {

    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;

    @Override
    public CreateItemOutput process(CreateItemInput input) {

        Vendor vendor = vendorRepository.findById(UUID.fromString(input.getVendorID()))
                .orElseThrow(NoSuchVendorException::new);

        Item item = Item.builder()
                .productName(input.getProductName())
                .description(input.getDescription())
                .vendor(vendor)
                .warrantyPeriod(input.getWarrantyPeriod())
                .build();

        itemRepository.save(item);

        return CreateItemOutput.builder()
                .itemID(item.getId().toString())
                .build();

    }
}