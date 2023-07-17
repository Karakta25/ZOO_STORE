package com.example.zoostoreproject.api.operations.tags.getAllItemTags;

import com.example.zoostoreproject.api.operations.base.OperationProcessor;

public interface GetAllItemTagsOperation extends OperationProcessor<GetAllItemTagsInput,GetAllItemTagsOutput> {
    GetAllItemTagsOutput process(GetAllItemTagsInput input);
}
