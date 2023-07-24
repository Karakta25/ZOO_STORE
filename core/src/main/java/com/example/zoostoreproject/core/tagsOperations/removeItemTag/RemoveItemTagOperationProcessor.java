package com.example.zoostoreproject.core.tagsOperations.removeItemTag;

import com.example.zoostoreproject.api.operations.tags.removeItemTags.RemoveItemTagsInput;
import com.example.zoostoreproject.api.operations.tags.removeItemTags.RemoveItemTagsOutput;
import com.example.zoostoreproject.api.operations.tags.removeItemTags.RemoveItemTagsOperation;
import com.example.zoostoreproject.core.exception.tag.NoSuchTagException;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemoveItemTagOperationProcessor implements RemoveItemTagsOperation {

    private final TagRepository tagRepository;
    @Override
    public RemoveItemTagsOutput process(RemoveItemTagsInput input) {

        Optional<Tag> optionalTag = tagRepository.findById(UUID.fromString(input.getTagID()));
        if(!optionalTag.isPresent())
            throw new NoSuchTagException();

        Tag tag = optionalTag.get();

        tagRepository.delete(tag);

        return RemoveItemTagsOutput.builder()
                .tagID(input.getTagID())
                .build();
    }
}
