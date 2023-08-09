package com.example.zoostoreproject.core.vendorOperations.getAllVendors;

import com.example.zoostoreproject.api.operations.item.GetItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.multimedia.GetMultimediaPropertiesOutput;
import com.example.zoostoreproject.api.operations.tags.GetTagPropertiesOutput;
import com.example.zoostoreproject.api.operations.vendor.GetVendorPropertiesOutput;
import com.example.zoostoreproject.api.operations.vendor.getAllVendors.GetAllVendorsInput;
import com.example.zoostoreproject.api.operations.vendor.getAllVendors.GetAllVendorsOutput;
import com.example.zoostoreproject.api.operations.vendor.getAllVendors.GetAllVendorsOperation;

import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Multimedia;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.entities.Vendor;
import com.example.zoostoreproject.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllVendorsOperationProcessor implements GetAllVendorsOperation {

    private final VendorRepository vendorRepository;
    @Override
    public GetAllVendorsOutput process(GetAllVendorsInput input) {

        List<GetVendorPropertiesOutput> vendors = vendorRepository.findAll()
                .stream()
                .map(this::mapVendorEntityToGetVendorPropertiesOutput)
                .collect(Collectors.toList());

        return GetAllVendorsOutput.builder()
                .vendorslist(vendors).build();
    }

    private GetVendorPropertiesOutput mapVendorEntityToGetVendorPropertiesOutput(Vendor vendor)
    {
        return GetVendorPropertiesOutput.builder()
                .id(vendor.getId().toString())
                .name(vendor.getName())
                .phone(vendor.getPhone())
                .items(getAllItems(vendor))
                .build();

    }

    private Set<GetItemPropertiesOutput> getAllItems(Vendor vendor)
    {
        return   vendor.getItems()
                .stream()
                .map(this::mapItemEntityToGetItemPropertiesOutput)
                .collect(Collectors.toSet());
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
