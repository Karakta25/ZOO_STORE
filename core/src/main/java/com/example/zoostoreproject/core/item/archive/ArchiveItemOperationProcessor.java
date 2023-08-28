package com.example.zoostoreproject.core.item.archive;


import com.example.zoostoreproject.api.operations.item.archive.ArchiveItemInput;
import com.example.zoostoreproject.api.operations.item.archive.ArchiveItemOutput;
import com.example.zoostoreproject.api.operations.item.archive.ArchiveItemOperation;
import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
