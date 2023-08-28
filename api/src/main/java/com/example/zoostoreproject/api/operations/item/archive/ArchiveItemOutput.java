package com.example.zoostoreproject.api.operations.item.archive;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveItemOutput implements OperationResult {

    private String itemID;
    private boolean archived;


}
