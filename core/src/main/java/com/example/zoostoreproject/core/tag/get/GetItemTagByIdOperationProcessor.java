package com.example.zoostoreproject.core.tag.get;

import com.example.zoostoreproject.api.operations.tags.get.byid.GetItemTagByIdInput;
import com.example.zoostoreproject.api.operations.tags.get.byid.GetItemTagByIdOutput;
import com.example.zoostoreproject.api.operations.tags.get.byid.GetItemTagByIdOperation;
import com.example.zoostoreproject.core.exception.tag.NoSuchTagException;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetItemTagByIdOperationProcessor implements GetItemTagByIdOperation {

    private final TagRepository tagRepository;
    @Override
    public GetItemTagByIdOutput process(GetItemTagByIdInput input) {

        Tag tag = tagRepository.findById(UUID.fromString(input.getTagID()))
                .orElseThrow(NoSuchTagException::new);

        return GetItemTagByIdOutput.builder()
                .tagId(tag.getId().toString())
                .title(tag.getTitle())
                .build();
    }


}
