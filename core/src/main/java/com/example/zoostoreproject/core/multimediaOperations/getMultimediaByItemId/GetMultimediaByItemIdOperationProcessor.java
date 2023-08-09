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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetMultimediaByItemIdOperationProcessor implements GetMultimediaByItemIdOperation {


    private final ItemRepository itemRepository;

    @Override
    public GetMultimediaByItemIdOutput process(GetMultimediaByItemIdInput input) {

        Item item = itemRepository.findById(UUID.fromString(input.getItemID()))
                .orElseThrow(NoSuchItemException::new);

        Set<String> mediaIds = item.getMultimedia()
                .stream()
                .map(media -> media.getId().toString())
                .collect(Collectors.toSet());

        Set<String> urls = item.getMultimedia()
                .stream()
                .map(Multimedia::getUrl)
                .collect(Collectors.toSet());

        return GetMultimediaByItemIdOutput.builder()
                .mediaID(mediaIds)
                .url(urls)
                .build();
    }
}
