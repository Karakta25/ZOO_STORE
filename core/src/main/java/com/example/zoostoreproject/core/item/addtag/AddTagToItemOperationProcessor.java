package com.example.zoostoreproject.core.item.addtag;

import com.example.zoostoreproject.api.operations.item.addtag.AddTagToItemInput;
import com.example.zoostoreproject.api.operations.item.addtag.AddTagToItemOperation;
import com.example.zoostoreproject.api.operations.item.addtag.AddTagToItemOutput;
import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
import com.example.zoostoreproject.core.exception.tag.NoSuchTagException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddTagToItemOperationProcessor implements AddTagToItemOperation {

    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;

    @Override
    public AddTagToItemOutput process(AddTagToItemInput input)  {

        Item item = itemRepository.findById(UUID.fromString(input.getItemId()))
                .orElseThrow(NoSuchItemException::new);

        Tag tag = tagRepository.findByTitle(input.getTitle())
                .orElseThrow(NoSuchTagException::new);

        item.getTags().add(tag);
        itemRepository.save(item);

        return AddTagToItemOutput.builder()
                .itemId(item.getId().toString())
                .title(tag.getTitle())
                .build();
    }
}
