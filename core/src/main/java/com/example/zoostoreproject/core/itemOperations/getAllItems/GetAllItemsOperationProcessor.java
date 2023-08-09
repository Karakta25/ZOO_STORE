package com.example.zoostoreproject.core.itemOperations.getAllItems;

import com.example.zoostoreproject.api.operations.item.GetItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsListInput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsListOutput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsOperation;
import com.example.zoostoreproject.api.operations.multimedia.GetMultimediaPropertiesOutput;
import com.example.zoostoreproject.api.operations.tags.GetTagPropertiesOutput;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Multimedia;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllItemsOperationProcessor implements GetAllItemsOperation {
    private final ItemRepository itemRepository;
    @Override
    public GetAllItemsListOutput process(GetAllItemsListInput input) {

        List<GetItemPropertiesOutput> items = itemRepository.findAll()
                .stream()
                .map(this::mapItemEntityToGetItemPropertiesOutput)
                .toList();


        return  GetAllItemsListOutput.builder()
                .itemslist(items)
                .build();
    }

    private GetItemPropertiesOutput mapItemEntityToGetItemPropertiesOutput(Item item)
    {
        return  GetItemPropertiesOutput
                .builder()
                .id(item.getId().toString())
                .productName(item.getProductName())
                .description(item.getDescription())
                .vendorName(item.getVendor().getName())
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
