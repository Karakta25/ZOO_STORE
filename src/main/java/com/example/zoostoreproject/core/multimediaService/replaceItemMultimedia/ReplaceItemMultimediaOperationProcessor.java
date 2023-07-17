package com.example.zoostoreproject.core.multimediaService.replaceItemMultimedia;

import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaOperation;
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

        Optional<Multimedia> multimediaOptional = multimediaRepository.findById(UUID.fromString(input.getMultimediaID()));

        Multimedia multimedia = multimediaOptional.get();


        multimedia.setUrl(input.getUrl());

        multimediaRepository.save(multimedia);

        return ReplaceItemMultimediaOutput.builder()
                .updateUrl(multimedia.getUrl())
                .multimediaID(multimedia.getId().toString())
                .build();
    }
}
