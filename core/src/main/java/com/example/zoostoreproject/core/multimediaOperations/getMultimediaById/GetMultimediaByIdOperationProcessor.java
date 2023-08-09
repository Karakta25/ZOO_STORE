package com.example.zoostoreproject.core.multimediaOperations.getMultimediaById;

import com.example.zoostoreproject.api.operations.multimedia.getMultimediaById.GetMultimediaByIdInput;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaById.GetMultimediaByIdOutput;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaById.GetMultimediaByIdOperation;

import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
import com.example.zoostoreproject.core.exception.multimedia.NoSuchMultimediaException;
import com.example.zoostoreproject.persistence.entities.Multimedia;
import com.example.zoostoreproject.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetMultimediaByIdOperationProcessor implements GetMultimediaByIdOperation {

    private final MultimediaRepository multimediaRepository;

    @Override
    public GetMultimediaByIdOutput process(GetMultimediaByIdInput input) {

        Multimedia multimedia = multimediaRepository.findById(UUID.fromString(input.getMediaID()))
                .orElseThrow(NoSuchMultimediaException::new);

        return GetMultimediaByIdOutput.builder()
                .mediaID(multimedia.getId().toString())
                .url(multimedia.getUrl())
                .itemID(multimedia.getItem().getId().toString())
                .build();
    }
}
