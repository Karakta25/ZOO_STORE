package com.example.zoostoreproject.core.tag.get;

import com.example.zoostoreproject.api.operations.tags.get.bytitle.GetItemTagByTitleInput;
import com.example.zoostoreproject.api.operations.tags.get.bytitle.GetItemTagByTitleOperation;
import com.example.zoostoreproject.api.operations.tags.get.bytitle.GetItemTagByTitleOutput;
import com.example.zoostoreproject.core.exception.tag.NoSuchTagException;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTagByTitleOperationProcessor implements GetItemTagByTitleOperation {

    private final TagRepository tagRepository;
    @Override
    public GetItemTagByTitleOutput process(GetItemTagByTitleInput input) {

        return GetItemTagByTitleOutput.builder()
                .tagId(tagRepository.findByTitle(input.getTagTitle()).orElseThrow(NoSuchTagException::new).getId().toString())
                .build();
    }
}
