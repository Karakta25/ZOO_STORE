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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GetAllItemsOperationProcessor implements GetAllItemsOperation {
    private final ItemRepository itemRepository;
    @Override
    public GetAllItemsListOutput process(GetAllItemsListInput input) {

        List<Item> itemsList = itemRepository.findAll();

        List<GetItemPropertiesOutput> items = new ArrayList<>();

        Set<GetMultimediaPropertiesOutput> multimedia = new HashSet<>();
        Set<GetTagPropertiesOutput> tags = new HashSet<>();

        for(Item item: itemsList)
        {
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

            GetItemPropertiesOutput getItemPropertiesOutput =
                    GetItemPropertiesOutput.builder()
                            .id(item.getId().toString())
                            .productName(item.getDescription())
                            .description(item.getDescription())
                            .archived(item.isArchived())
                            .vendorId(item.getVendor().getId().toString())
                            .multimedia(multimedia)
                            .tags(tags)
                            .build();


            items.add(getItemPropertiesOutput);
        }

        return GetAllItemsListOutput.builder().itemslist(items).build();




    }
}
