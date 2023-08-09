package com.example.zoostoreproject.core.itemOperations.archiveItem;


import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemInput;
import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemOutput;
import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemOperation;
import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
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

        Item item = itemRepository.findById(UUID.fromString(input.getItemID()))
                .orElseThrow(NoSuchItemException::new);

        item.setArchived(input.getArchived());
        itemRepository.save(item);

        return ArchiveItemOutput.builder()
                .itemID(item.getId().toString())
                .archived(item.isArchived())
                .build();
    }
}
