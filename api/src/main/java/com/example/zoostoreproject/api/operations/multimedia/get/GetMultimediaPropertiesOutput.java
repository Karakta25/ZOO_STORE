package com.example.zoostoreproject.api.operations.multimedia.get;

import com.example.zoostoreproject.api.operations.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMultimediaPropertiesOutput implements OperationResult {

        private String mediaID;
        private String url;
}