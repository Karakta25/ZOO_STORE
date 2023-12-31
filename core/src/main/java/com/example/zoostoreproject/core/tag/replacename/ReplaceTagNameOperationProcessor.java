package com.example.zoostoreproject.core.tag.replacename;

import com.example.zoostoreproject.api.operations.tags.replacename.ReplaceTagNameInput;
import com.example.zoostoreproject.api.operations.tags.replacename.ReplaceTagNameOutput;
import com.example.zoostoreproject.api.operations.tags.replacename.ReplaceTagNameOperation;
import com.example.zoostoreproject.core.exception.tag.NoSuchTagException;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReplaceTagNameOperationProcessor implements ReplaceTagNameOperation {

    private final TagRepository tagRepository;
    @Override
    public ReplaceTagNameOutput process(ReplaceTagNameInput input) {


        Tag tag = tagRepository.findById(UUID.fromString(input.getTagID()))
                .orElseThrow(NoSuchTagException::new);

        tag.setTitle(input.getTitle());

        tagRepository.save(tag);

        return  ReplaceTagNameOutput.builder()
                .tagID(tag.getId().toString())
                .title(tag.getTitle())
                .build();
    }
}
