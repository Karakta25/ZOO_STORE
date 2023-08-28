package com.example.zoostoreproject.api.operations.item.get.byid;

import com.example.zoostoreproject.api.operations.multimedia.get.GetMultimediaPropertiesOutput;
import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.api.operations.tags.get.GetTagPropertiesOutput;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemByIdOutput implements OperationResult {

    private String id;
    private String productName;
    private String description;
    private String vendorId;
    private Set<GetMultimediaPropertiesOutput> multimedia;
    private Set<GetTagPropertiesOutput> tags;
    private boolean archived;
}

