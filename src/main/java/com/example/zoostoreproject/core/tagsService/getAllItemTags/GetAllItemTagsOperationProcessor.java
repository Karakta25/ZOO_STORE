package com.example.zoostoreproject.core.tagsService.getAllItemTags;

import com.example.zoostoreproject.api.operations.tags.GetTagPropertiesOutput;
import com.example.zoostoreproject.api.operations.tags.getAllItemTags.GetAllItemTagsInput;
import com.example.zoostoreproject.api.operations.tags.getAllItemTags.GetAllItemTagsOutput;
import com.example.zoostoreproject.api.operations.tags.getAllItemTags.GetAllItemTagsOperation;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllItemTagsOperationProcessor implements GetAllItemTagsOperation {

    private final TagRepository tagRepository;

    @Override
    public GetAllItemTagsOutput process(GetAllItemTagsInput input) {

        List<Tag> tagsList = tagRepository.findAll();

        List<GetTagPropertiesOutput> tags = new ArrayList<>();

        for(Tag tag: tagsList)
        {
            GetTagPropertiesOutput getTagPropertiesOutput = GetTagPropertiesOutput.builder()
                    .tagId(tag.getId().toString())
                    .title(tag.getTitle())
                    .build();

            tags.add(getTagPropertiesOutput);
        }

        return GetAllItemTagsOutput.builder().tagsList(tags).build();
    }
}
