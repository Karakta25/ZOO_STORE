package com.example.zoostoreproject.core.multimediaService.addItemMultimedia;


import com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia.AddItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia.AddItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia.AddItemMultimediaOperation;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Multimedia;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import com.example.zoostoreproject.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddItemMultimediaOperationProcessor implements AddItemMultimediaOperation {


    private final MultimediaRepository multimediaRepository;
    private final ItemRepository itemRepository;

    @Override
    public AddItemMultimediaOutput process(AddItemMultimediaInput input) {


        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getItemID()));

        Item item = optionalItem.get();
        Multimedia multimedia = Multimedia.builder()
                                          .url(input.getUrl())
                                          .item(item)
                                          .build();

        multimediaRepository.save(multimedia);
        return AddItemMultimediaOutput.builder()
                .multimediaID(multimedia.getId().toString())
                .build();
    }
}
