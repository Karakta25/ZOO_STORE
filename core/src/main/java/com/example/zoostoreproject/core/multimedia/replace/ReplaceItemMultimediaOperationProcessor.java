package com.example.zoostoreproject.core.multimedia.replace;

import com.example.zoostoreproject.api.operations.multimedia.replace.ReplaceItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.replace.ReplaceItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.replace.ReplaceItemMultimediaOperation;
import com.example.zoostoreproject.core.exception.multimedia.NoSuchMultimediaException;
import com.example.zoostoreproject.persistence.entities.Multimedia;
import com.example.zoostoreproject.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReplaceItemMultimediaOperationProcessor implements ReplaceItemMultimediaOperation {

    private final MultimediaRepository multimediaRepository;
    @Override
    public ReplaceItemMultimediaOutput process(ReplaceItemMultimediaInput input) {

        Multimedia multimedia = multimediaRepository.findById(UUID.fromString(input.getMediaID()))
                .orElseThrow(NoSuchMultimediaException::new);

        multimedia.setUrl(input.getUrl());

        multimediaRepository.save(multimedia);

        return ReplaceItemMultimediaOutput.builder()
                .updateUrl(multimedia.getUrl())
                .multimediaID(multimedia.getId().toString())
                .build();
    }
}
