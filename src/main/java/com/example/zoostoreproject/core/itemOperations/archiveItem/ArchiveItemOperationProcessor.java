package com.example.zoostoreproject.core.itemOperations.archiveItem;


import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemInput;
import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemOutput;
import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemOperation;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArchiveItemOperationProcessor implements ArchiveItemOperation {

    private final ItemRepository itemRepository;
    @Override
    public ArchiveItemOutput process(ArchiveItemInput input) {

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemID()));

        Item item = optionalItem.get();

        item.setArchived(input.isArchived());
        itemRepository.save(item);

        ArchiveItemOutput archiveItemOutput = ArchiveItemOutput.builder()
                .itemID(item.getId().toString())
                .archived(item.isArchived())
                .build();

        return archiveItemOutput;
    }
}
