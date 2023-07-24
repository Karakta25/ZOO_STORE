package com.example.zoostoreproject.core.vendorOperations.getVendorById;

import com.example.zoostoreproject.api.operations.item.GetItemPropertiesOutput;
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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetVendorByIdOperationProcessor implements GetVendorByIdOperation {

    private final VendorRepository vendorRepository;

    @Override
    public GetVendorByIdOutput process(GetVendorByIdInput input) {

        Optional<Vendor> vendorOptional = vendorRepository.findById(UUID.fromString(input.getId()));
        if(!vendorOptional.isPresent())
            throw new NoSuchVendorException();

        Vendor vendor = vendorOptional.get();

        Set<GetItemPropertiesOutput> items = new HashSet<>();
        Set<GetMultimediaPropertiesOutput> multimedia = new HashSet<>();
        Set<GetTagPropertiesOutput> tags = new HashSet<>();

        for(Item item: vendor.getItems())
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

        return GetVendorByIdOutput.builder()
                .id(vendor.getId().toString())
                .name(vendor.getName())
                .phone(vendor.getPhone())
                .items(items)
                .build();

    }
}

/*vendor.getItems() retrieves a collection (such as a List or Set) of objects from the vendor object. This assumes that vendor has a method named getItems() that returns a collection.

.stream() converts the collection into a Stream. A Stream is a sequence of elements that can be processed in a pipeline.

.map(String::valueOf) applies the valueOf method of the String class to each element of the Stream. The valueOf method converts an object to its string representation. By using String::valueOf, we are treating the valueOf method as a function reference.

.collect(Collectors.toSet()) collects the Stream elements into a Set. The Collectors.toSet() method is a collector that accumulates the elements of the Stream into a new Set.*/