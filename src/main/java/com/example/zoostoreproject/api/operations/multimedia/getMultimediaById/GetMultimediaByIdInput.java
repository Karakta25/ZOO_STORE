package com.example.zoostoreproject.api.operations.multimedia.getMultimediaById;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMultimediaByIdInput implements OperationInput {

    private String mediaID;
}
