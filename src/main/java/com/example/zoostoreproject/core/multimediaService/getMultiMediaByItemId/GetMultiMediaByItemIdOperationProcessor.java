package com.example.zoostoreproject.core.multimediaService.getMultiMediaByItemId;

import com.example.zoostoreproject.api.operations.multimedia.getMultiMediaByItemId.GetMultiMediaByItemIdInput;
import com.example.zoostoreproject.api.operations.multimedia.getMultiMediaByItemId.GetMultiMediaByItemIdOperation;
import com.example.zoostoreproject.api.operations.multimedia.getMultiMediaByItemId.GetMultiMediaByItemIdOutput;
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
public class GetMultiMediaByItemIdOperationProcessor implements GetMultiMediaByItemIdOperation {


    private final ItemRepository itemRepository;

    @Override
    public GetMultiMediaByItemIdOutput process(GetMultiMediaByItemIdInput input) {

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemID()));

        Item item = optionalItem.get();

        Set<String> mediaIds = new HashSet<>();
        Set<String> urls = new HashSet<>();

        for(Multimedia media : item.getMultimedia())
        {
            mediaIds.add(media.getId().toString());
            urls.add(media.getUrl());
        }

        return GetMultiMediaByItemIdOutput.builder()
                .mediaID(mediaIds)
                .url(urls)
                .build();
    }
}
