package com.example.zoostoreproject.core.tag.get;

import com.example.zoostoreproject.api.operations.tags.get.GetTagPropertiesOutput;
import com.example.zoostoreproject.api.operations.tags.get.alltags.GetAllItemTagsInput;
import com.example.zoostoreproject.api.operations.tags.get.alltags.GetAllItemTagsOutput;
import com.example.zoostoreproject.api.operations.tags.get.alltags.GetAllItemTagsOperation;
import com.example.zoostoreproject.persistence.entities.Tag;
import com.example.zoostoreproject.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllItemTagsOperationProcessor implements GetAllItemTagsOperation {

    private final TagRepository tagRepository;

    @Override
    public GetAllItemTagsOutput process(GetAllItemTagsInput input) {

        List<Tag> tagsList = tagRepository.findAll();

        List<GetTagPropertiesOutput> tags = tagsList
                                                .stream()
                                                .map(tag -> GetTagPropertiesOutput.builder()
                                                        .tagId(tag.getId().toString())
                                                        .title(tag.getTitle())
                                                        .build())
                                                .collect(Collectors.toList());

        return GetAllItemTagsOutput.builder()
                .tagsList(tags)
                .build();
    }
}
