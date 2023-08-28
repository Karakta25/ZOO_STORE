package com.example.zoostoreproject.core.item.removetag;

import com.example.zoostoreproject.api.operations.item.removetag.RemoveTagFromItemInput;
import com.example.zoostoreproject.api.operations.item.removetag.RemoveTagFromItemOperation;
import com.example.zoostoreproject.api.operations.item.removetag.RemoveTagFromItemOutput;
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
public class RemoveTagFromItemOperationProcessor implements RemoveTagFromItemOperation {

    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;
    @Override
    public RemoveTagFromItemOutput process(RemoveTagFromItemInput input)  {

        Item item = itemRepository.findById(UUID.fromString(input.getItemId()))
                .orElseThrow(NoSuchItemException::new);

        Tag tag = tagRepository.findByTitle(input.getTitle())
                .orElseThrow(NoSuchTagException::new);


        item.getTags().remove(tag);
        itemRepository.save(item);

        return RemoveTagFromItemOutput.builder()
                .itemId(item.getId().toString())
                .title(tag.getTitle())
                .build();
    }
}

