package com.example.zoostoreproject.core.itemOperations.addTagToItem;

import com.example.zoostoreproject.api.operations.item.addTagToItem.AddTagToItemInput;
import com.example.zoostoreproject.api.operations.item.addTagToItem.AddTagToItemOperation;
import com.example.zoostoreproject.api.operations.item.addTagToItem.AddTagToItemOutput;
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
public class AddTagToItemOperationProcessor implements AddTagToItemOperation {

    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;

    @Override
    public AddTagToItemOutput process(AddTagToItemInput input)  {

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemId()));

        if(!optionalItem.isPresent())
            throw new NoSuchItemException();

        Item item = optionalItem.get();


        Optional<Tag> optionalTag = tagRepository.findByTitle(input.getTitle());

        if(!optionalTag.isPresent())
            throw new NoSuchTagException();

        Tag tag = optionalTag.get();


        item.getTags().add(tag);
        itemRepository.save(item);

        return AddTagToItemOutput.builder()
                .itemId(item.getId().toString())
                .title(tag.getTitle())
                .build();
    }
}
