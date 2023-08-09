package com.example.zoostoreproject.core.vendorOperations.getVendorById;

import com.example.zoostoreproject.api.operations.item.GetItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsListOutput;
import com.example.zoostoreproject.api.operations.multimedia.GetMultimediaPropertiesOutput;
import com.example.zoostoreproject.api.operations.tags.GetTagPropertiesOutput;
import com.example.zoostoreproject.api.operations.vendor.getVendorById.GetVendorByIdInput;
import com.example.zoostoreproject.api.operations.vendor.getVendorById.GetVendorByIdOutput;
import com.example.zoostoreproject.api.operations.vendor.getVendorById.GetVendorByIdOperation;
import com.example.zoostoreproject.core.exception.vendor.NoSuchVendorException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Multimedia;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetVendorByIdOperationProcessor implements GetVendorByIdOperation {

    private final VendorRepository vendorRepository;


    @Override
    public GetVendorByIdOutput process(GetVendorByIdInput input) {

        Vendor vendor = vendorRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(NoSuchVendorException::new);


       Set <GetItemPropertiesOutput> items =
                vendor.getItems()
                .stream()
                .map(this::mapItemEntityToGetItemPropertiesOutput)
                .collect(Collectors.toSet());


       return GetVendorByIdOutput.builder()
                .id(vendor.getId().toString())
                .name(vendor.getName())
                .phone(vendor.getPhone())
                .items(items)
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

