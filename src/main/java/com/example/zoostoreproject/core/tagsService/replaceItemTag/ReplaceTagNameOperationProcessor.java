package com.example.zoostoreproject.core.tagsService.replaceItemTag;

import com.example.zoostoreproject.api.operations.tags.replaceTagName.ReplaceTagNameInput;
import com.example.zoostoreproject.api.operations.tags.replaceTagName.ReplaceTagNameOutput;
import com.example.zoostoreproject.api.operations.tags.replaceTagName.ReplaceTagNameOperation;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReplaceTagNameOperationProcessor implements ReplaceTagNameOperation {

    private final TagRepository tagRepository;
    @Override
    public ReplaceTagNameOutput process(ReplaceTagNameInput input) {


        Optional<Tag> tagOptional = tagRepository.findById(UUID.fromString(input.getTagID()));

        Tag tag = tagOptional.get();

        tag.setTitle(input.getTitle());

        tagRepository.save(tag);

        return  ReplaceTagNameOutput.builder()
                .tagID(tag.getId().toString())
                .title(tag.getTitle())
                .build();
    }
}
