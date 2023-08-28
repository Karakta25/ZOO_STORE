package com.example.zoostoreproject.core.tag.remove;

import com.example.zoostoreproject.api.operations.tags.remove.RemoveItemTagsInput;
import com.example.zoostoreproject.api.operations.tags.remove.RemoveItemTagsOutput;
import com.example.zoostoreproject.api.operations.tags.remove.RemoveItemTagsOperation;
import com.example.zoostoreproject.core.exception.tag.NoSuchTagException;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemoveItemTagOperationProcessor implements RemoveItemTagsOperation {

    private final TagRepository tagRepository;
    @Override
    public RemoveItemTagsOutput process(RemoveItemTagsInput input) {

        Tag tag = tagRepository.findById(UUID.fromString(input.getTagID()))
                .orElseThrow(NoSuchTagException::new);

        tagRepository.delete(tag);

        return RemoveItemTagsOutput.builder()
                .tagID(input.getTagID())
                .build();
    }
}
