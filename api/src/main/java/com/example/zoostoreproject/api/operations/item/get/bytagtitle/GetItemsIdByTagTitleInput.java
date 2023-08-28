package com.example.zoostoreproject.api.operations.item.get.bytagtitle;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemsIdByTagTitleInput implements OperationInput {

    private List<UUID> cartItemsId;
    private String tagTitle;
}
