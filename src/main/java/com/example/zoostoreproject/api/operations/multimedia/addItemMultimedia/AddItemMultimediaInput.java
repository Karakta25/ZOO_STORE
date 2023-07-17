package com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddItemMultimediaInput implements OperationInput {

    private String url;
    private String itemID;
}
