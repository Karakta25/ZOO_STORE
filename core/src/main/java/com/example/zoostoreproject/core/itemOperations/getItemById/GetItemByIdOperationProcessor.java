package com.example.zoostoreproject.core.itemOperations.getItemById;


import com.example.zoostoreproject.api.operations.item.GetItemPropertiesOutput;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetItemByIdOperationProcessor implements GetItemByIdOperation {

   private final ItemRepository itemRepository;
    @Override
    public GetItemByIdOutput process(GetItemByIdInput input) {

        Item item = itemRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(NoSuchItemException::new);

        return  GetItemByIdOutput
                .builder()
                .id(item.getId().toString())
                .productName(item.getProductName())
                .description(item.getDescription())
                .vendorId(item.getVendor().getName())
                .multimedia(mapMultimediaEntityToGetMultimediaPropertiesOutputSet(item.getMultimedia()))
                .tags(mapTagEntityToGetTagPropertiesOutputSet(item.getTags()))
                .archived(item.isArchived())
                .build();

    }

    private Set<GetMultimediaPropertiesOutput> mapMultimediaEntityToGetMultimediaPropertiesOutputSet(Set<Multimedia> multimedia)
    {
        return multimedia
                .stream()
                .map(this::mapMultimediaEntityToGetMultimediaPropertiesOutput)
                .collect(Collectors.toSet());
    }
    private GetMultimediaPropertiesOutput mapMultimediaEntityToGetMultimediaPropertiesOutput(Multimedia multimedia)
    {
        return GetMultimediaPropertiesOutput.builder()
                .mediaID(multimedia.getId().toString())
                .url(multimedia.getUrl())
                .build();
    }


    private Set<GetTagPropertiesOutput> mapTagEntityToGetTagPropertiesOutputSet(Set<Tag> tag)
    {
        return tag
                .stream()
                .map(this::mapTagEntityToGetMultimediaPropertiesOutput)
                .collect(Collectors.toSet());
    }
    private GetTagPropertiesOutput mapTagEntityToGetMultimediaPropertiesOutput(Tag tag)
    {
        return GetTagPropertiesOutput.builder()
                .tagId(tag.getId().toString())
                .title(tag.getTitle())
                .build();
    }




}












