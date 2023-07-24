package com.example.zoostoreproject.core.multimediaOperations.replaceItemMultimedia;

import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaOperation;
import com.example.zoostoreproject.core.exception.multimedia.NoSuchMultimediaException;
import com.example.zoostoreproject.persistence.entities.Multimedia;
import com.example.zoostoreproject.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReplaceItemMultimediaOperationProcessor implements ReplaceItemMultimediaOperation {

    private final MultimediaRepository multimediaRepository;
    @Override
    public ReplaceItemMultimediaOutput process(ReplaceItemMultimediaInput input) {

        Optional<Multimedia> optionalMultimedia = multimediaRepository.findById(UUID.fromString(input.getMediaID()));
        if(!optionalMultimedia.isPresent())
            throw new NoSuchMultimediaException();
        Multimedia multimedia = optionalMultimedia.get();


        multimedia.setUrl(input.getUrl());

        multimediaRepository.save(multimedia);

        return ReplaceItemMultimediaOutput.builder()
                .updateUrl(multimedia.getUrl())
                .multimediaID(multimedia.getId().toString())
                .build();
    }
}
