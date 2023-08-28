package com.example.zoostoreproject.api.operations.item.get.bytagtitle;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemsIdByTagTitleOutput implements OperationResult{

    List<UUID> itemsId;
}
