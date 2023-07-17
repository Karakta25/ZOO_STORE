package com.example.zoostoreproject.rest.controllers;

import com.example.zoostoreproject.api.operations.tags.addTag.AddTagInput;
import com.example.zoostoreproject.api.operations.tags.addTag.AddTagOutput;
import com.example.zoostoreproject.api.operations.tags.addTag.AddTagOperation;
import com.example.zoostoreproject.api.operations.tags.getAllItemTags.GetAllItemTagsInput;
import com.example.zoostoreproject.api.operations.tags.getAllItemTags.GetAllItemTagsOutput;
import com.example.zoostoreproject.api.operations.tags.getAllItemTags.GetAllItemTagsOperation;
import com.example.zoostoreproject.api.operations.tags.getItemTagById.GetItemTagByIdInput;
import com.example.zoostoreproject.api.operations.tags.getItemTagById.GetItemTagByIdOutput;
import com.example.zoostoreproject.api.operations.tags.getItemTagById.GetItemTagByIdOperation;
import com.example.zoostoreproject.api.operations.tags.removeItemTags.RemoveItemTagsInput;
import com.example.zoostoreproject.api.operations.tags.removeItemTags.RemoveItemTagsOutput;
import com.example.zoostoreproject.api.operations.tags.removeItemTags.RemoveItemTagsOperation;
import com.example.zoostoreproject.api.operations.tags.replaceTagName.ReplaceTagNameInput;
import com.example.zoostoreproject.api.operations.tags.replaceTagName.ReplaceTagNameOutput;
import com.example.zoostoreproject.api.operations.tags.replaceTagName.ReplaceTagNameOperation;
import com.example.zoostoreproject.core.exception.WrongDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequestMapping(path = "/tags")
@RequiredArgsConstructor
public class TagsController {

    private final AddTagOperation addTagOperation;
    private final RemoveItemTagsOperation removeItemTagsOperation;
    private final ReplaceTagNameOperation replaceTagNameOperation;
    private final GetAllItemTagsOperation getAllItemTagsOperation;
    private final GetItemTagByIdOperation getItemTagByIdOperation;



    @PostMapping(path = "tags/add")
    public AddTagOutput addItemTag(@RequestBody AddTagInput input) throws WrongDataException {
        return addTagOperation.process(input);
    }

    @DeleteMapping(path = "tags/remove")
    public RemoveItemTagsOutput removeItemTag(RemoveItemTagsInput input) throws WrongDataException {
        return removeItemTagsOperation.process(input);
    }

    @PostMapping(path = "tags/replace")
    public ReplaceTagNameOutput replaceItemTag(ReplaceTagNameInput input) throws WrongDataException {
        return replaceTagNameOperation.process(input);
    }

    @GetMapping(path = "tags/getAll")
    public GetAllItemTagsOutput getAllTags(GetAllItemTagsInput input) {

        return getAllItemTagsOperation.process(input);
    }

    @GetMapping(path = "tags/getById/{id}")
    public GetItemTagByIdOutput getItemTagById(@RequestParam UUID Id) throws WrongDataException {
       GetItemTagByIdInput input = GetItemTagByIdInput.builder().tagId(Id.toString()).build();
        return getItemTagByIdOperation.process(input);
    }

    @PatchMapping(path = "tags/replaceTagName")
    public ReplaceTagNameOutput replaceTagNameOutput(@RequestBody ReplaceTagNameInput input) throws WrongDataException {
        return replaceTagNameOperation.process(input);
    }

}
