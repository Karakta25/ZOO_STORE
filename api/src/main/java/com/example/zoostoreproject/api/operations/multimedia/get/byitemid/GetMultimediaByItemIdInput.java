package com.example.zoostoreproject.api.operations.multimedia.get.byitemid;

import com.example.zoostoreproject.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMultimediaByItemIdInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String itemID;
}
