package com.example.zoostoreproject.core.multimedia.remove;

import com.example.zoostoreproject.api.operations.multimedia.remove.RemoveItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.remove.RemoveItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.remove.RemoveItemMultimediaOperation;
import com.example.zoostoreproject.core.exception.multimedia.NoSuchMultimediaException;
import com.example.zoostoreproject.persistence.entities.Multimedia;
import com.example.zoostoreproject.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemoveItemMultimediaOperationProcessor implements RemoveItemMultimediaOperation {

    private final MultimediaRepository multimediaRepository;
    @Override
    public RemoveItemMultimediaOutput process(RemoveItemMultimediaInput input) {

        Multimedia multimedia = multimediaRepository.findById(UUID.fromString(input.getMediaID()))
                .orElseThrow(NoSuchMultimediaException::new);

        multimediaRepository.delete(multimedia);

        return RemoveItemMultimediaOutput.builder()
                .multimediaID(input.getMediaID())
                .build();
    }
}
