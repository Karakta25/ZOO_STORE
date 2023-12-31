package com.example.zoostoreproject.core.tag.add;

import com.example.zoostoreproject.api.operations.tags.add.AddTagInput;
import com.example.zoostoreproject.api.operations.tags.add.AddTagOutput;
import com.example.zoostoreproject.api.operations.tags.add.AddTagOperation;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddTagOperationProcessor implements AddTagOperation {

    private final TagRepository tagRepository;

    @Override
    public AddTagOutput process(AddTagInput input) {

        Tag tag = Tag.builder()
                .title(input.getTitle())
                .build();

        tagRepository.save(tag);

        return AddTagOutput.builder()
                .tagID(tag.getId().toString())
                .build();
    }
}
