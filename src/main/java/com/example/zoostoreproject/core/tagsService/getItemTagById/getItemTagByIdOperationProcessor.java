package com.example.zoostoreproject.core.tagsService.getItemTagById;

import com.example.zoostoreproject.api.operations.tags.getItemTagById.GetItemTagByIdInput;
import com.example.zoostoreproject.api.operations.tags.getItemTagById.GetItemTagByIdOutput;
import com.example.zoostoreproject.api.operations.tags.getItemTagById.GetItemTagByIdOperation;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class getItemTagByIdOperationProcessor implements GetItemTagByIdOperation {

    private final TagRepository tagRepository;
    @Override
    public GetItemTagByIdOutput process(GetItemTagByIdInput input) {

        Optional<Tag> optionalTag = tagRepository.findById(UUID.fromString(input.getTagId()));

        Tag tag = optionalTag.get();

        return GetItemTagByIdOutput.builder()
                .tagId(tag.getId().toString())
                .title(tag.getTitle())
                .build();
    }


}
