package com.example.zoostoreproject.api.operations.item.get;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import com.example.zoostoreproject.api.operations.multimedia.get.GetMultimediaPropertiesOutput;
import com.example.zoostoreproject.api.operations.tags.get.GetTagPropertiesOutput;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemPropertiesOutput implements OperationResult {

    private String id;
    private String productName;
    private String description;
    private String vendorName;
    private Set<GetMultimediaPropertiesOutput> multimedia;
    private Set<GetTagPropertiesOutput> tags;
    private boolean archived;
}
