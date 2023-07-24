package com.example.zoostoreproject.core.itemOperations.getItemById;


import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdInput;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdOperation;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdOutput;
import com.example.zoostoreproject.api.operations.multimedia.GetMultimediaPropertiesOutput;
import com.example.zoostoreproject.api.operations.tags.GetTagPropertiesOutput;
import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Multimedia;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetItemByIdOperationProcessor implements GetItemByIdOperation {

   private final ItemRepository itemRepository;
    @Override
    public GetItemByIdOutput process(GetItemByIdInput input) {

        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(input.getId()));

        if(!optionalItem.isPresent())
            throw new NoSuchItemException();

        Item item = optionalItem.get();

        Set<GetMultimediaPropertiesOutput> multimedia = new HashSet<>();
        Set<GetTagPropertiesOutput> tags = new HashSet<>();

            for(Multimedia media : item.getMultimedia())
            {
                GetMultimediaPropertiesOutput getMultimediaPropertiesOutput
                        = GetMultimediaPropertiesOutput.builder()
                        .mediaID(media.getId().toString())
                        .url(media.getUrl()).build();

                multimedia.add(getMultimediaPropertiesOutput);
            }

            for(Tag tag : item.getTags())
            {
                GetTagPropertiesOutput getTagPropertiesOutput
                        = GetTagPropertiesOutput.builder()
                        .tagId(tag.getId().toString())
                        .title(tag.getTitle())
                        .build();

                tags.add(getTagPropertiesOutput);
            }
        return GetItemByIdOutput.builder()
                .id(item.getId().toString())
                .productName(item.getProductName())
                .description(item.getDescription())
                .archived(item.isArchived())
                .vendorId(item.getVendor().getId().toString())
                .multimedia(multimedia)
                .tags(tags)
                .build();
    }


}












