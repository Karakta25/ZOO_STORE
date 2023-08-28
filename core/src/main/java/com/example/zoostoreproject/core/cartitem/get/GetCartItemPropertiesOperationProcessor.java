package com.example.zoostoreproject.core.cartitem.get;

import com.example.zoostoreproject.api.operations.item.get.GetItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.cartitem.getproperties.GetCartItemPropertiesInput;
import com.example.zoostoreproject.api.operations.cartitem.getproperties.GetCartItemPropertiesOperation;
import com.example.zoostoreproject.api.operations.cartitem.getproperties.GetCartItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.multimedia.get.GetMultimediaPropertiesOutput;
import com.example.zoostoreproject.api.operations.tags.get.GetTagPropertiesOutput;
import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
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
public class GetCartItemPropertiesOperationProcessor implements GetCartItemPropertiesOperation {

    private final ItemRepository itemRepository;
    @Override
    public GetCartItemPropertiesOutput process(GetCartItemPropertiesInput input) {


        List<GetItemPropertiesOutput> items = input.getItemsId()
                .stream()
                .map(itemId -> itemRepository.findById(itemId)
                        .orElseThrow(NoSuchItemException::new))
                .map(this::mapItemEntityToGetItemPropertiesOutput)
                .collect(Collectors.toList());

        return  GetCartItemPropertiesOutput.builder()
                .itemsList(items)
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
