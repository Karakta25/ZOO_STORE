package com.example.zoostoreproject.core.multimediaOperations.getMultimediaByItemId;

import com.example.zoostoreproject.api.operations.multimedia.getMultimediaByItemId.GetMultimediaByItemIdInput;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaByItemId.GetMultimediaByItemIdOperation;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaByItemId.GetMultimediaByItemIdOutput;
import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
import com.example.zoostoreproject.core.exception.multimedia.NoSuchMultimediaException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Multimedia;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetMultimediaByItemIdOperationProcessor implements GetMultimediaByItemIdOperation {


    private final ItemRepository itemRepository;

    @Override
    public GetMultimediaByItemIdOutput process(GetMultimediaByItemIdInput input) {

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemID()));
        if(!optionalItem.isPresent())
            throw new NoSuchItemException();

        Item item = optionalItem.get();

        Set<String> mediaIds = new HashSet<>();
        Set<String> urls = new HashSet<>();

        for(Multimedia media : item.getMultimedia())
        {
            mediaIds.add(media.getId().toString());
            urls.add(media.getUrl());
        }

        return GetMultimediaByItemIdOutput.builder()
                .mediaID(mediaIds)
                .url(urls)
                .build();
    }
}
