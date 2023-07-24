package com.example.zoostoreproject.core.itemOperations.removeTagFromItem;

import com.example.zoostoreproject.api.operations.item.removeTagFromItem.RemoveTagFromItemInput;
import com.example.zoostoreproject.api.operations.item.removeTagFromItem.RemoveTagFromItemOperation;
import com.example.zoostoreproject.api.operations.item.removeTagFromItem.RemoveTagFromItemOutput;
import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
import com.example.zoostoreproject.core.exception.tag.NoSuchTagException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemoveTagFromItemOperationProcessor implements RemoveTagFromItemOperation {

    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;
    @Override
    public RemoveTagFromItemOutput process(RemoveTagFromItemInput input)  {

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemId()));
        if(!optionalItem.isPresent())
            throw new NoSuchItemException();

        Optional<Tag> optionalTag = tagRepository.findByTitle(input.getTitle());
        if(!optionalTag.isPresent())
            throw new NoSuchTagException();

        Item item = optionalItem.get();
        Tag tag = optionalTag.get();


        item.getTags().remove(tag);
        itemRepository.save(item);

        return RemoveTagFromItemOutput.builder()
                .itemId(item.getId().toString())
                .title(tag.getTitle())
                .build();
    }
    }

