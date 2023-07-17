package com.example.zoostoreproject.api.operations.item.archiveItem;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ArchiveItemInput implements OperationInput {
    private String itemID;
    private boolean archived;
}
