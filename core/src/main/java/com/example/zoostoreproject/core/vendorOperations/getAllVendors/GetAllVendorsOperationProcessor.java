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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GetAllVendorsOperationProcessor implements GetAllVendorsOperation {

    private final VendorRepository vendorRepository;
    @Override
    public GetAllVendorsOutput process(GetAllVendorsInput input) {

        List<Vendor> vendorsList = vendorRepository.findAll();

        List<GetVendorPropertiesOutput> vendors = new ArrayList<>();

        Set<GetItemPropertiesOutput> items = new HashSet<>();
        Set<GetMultimediaPropertiesOutput> multimedia = new HashSet<>();
        Set<GetTagPropertiesOutput> tags = new HashSet<>();



        for(Vendor vendor : vendorsList)
        {
            for(Item item:vendor.getItems())
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

            GetVendorPropertiesOutput getVendorPropertiesOutput =
                    GetVendorPropertiesOutput.builder()
                            .id(vendor.getId().toString())
                            .phone(vendor.getPhone())
                            .name(vendor.getName())
                            .items(items).build();

            vendors.add(getVendorPropertiesOutput);
        }

        return GetAllVendorsOutput.builder()
                .vendorslist(vendors).build();
    }
}
