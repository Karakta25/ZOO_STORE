package com.example.zoostoreproject.core.multimediaService.removeItemMultimedia;

import com.example.zoostoreproject.api.operations.multimedia.removeItemMultimedia.RemoveItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.removeItemMultimedia.RemoveItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.removeItemMultimedia.RemoveItemMultimediaOperation;
import com.example.zoostoreproject.persistence.entities.Multimedia;
import com.example.zoostoreproject.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemoveItemMultimediaOperationProcessor implements RemoveItemMultimediaOperation {

    private final MultimediaRepository multimediaRepository;
    @Override
    public RemoveItemMultimediaOutput process(RemoveItemMultimediaInput input) {

        Optional<Multimedia> optionalMultimedia = multimediaRepository.findById(UUID.fromString(input.getMultimediaID()));

        Multimedia multimedia = optionalMultimedia.get();

        multimediaRepository.delete(multimedia);

        return RemoveItemMultimediaOutput.builder()
                .multimediaID(input.getMultimediaID())
                .build();
    }
}
