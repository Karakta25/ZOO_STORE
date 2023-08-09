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

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tag")
@RequiredArgsConstructor
public class TagsController {

    private final AddTagOperation addTagOperation;
    private final RemoveItemTagsOperation removeItemTagsOperation;
    private final ReplaceTagNameOperation replaceTagNameOperation;
    private final GetAllItemTagsOperation getAllItemTagsOperation;
    private final GetItemTagByIdOperation getItemTagByIdOperation;




    @PostMapping()
    public ResponseEntity<AddTagOutput> addItemTag(@Valid @RequestBody AddTagInput input)  {

        AddTagOutput response = addTagOperation.process(input);
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping()
    public ResponseEntity<RemoveItemTagsOutput> removeItemTag(@Valid @RequestBody RemoveItemTagsInput input)  {

        RemoveItemTagsOutput response = removeItemTagsOperation.process(input);
        return ResponseEntity.ok(response);
    }


    @GetMapping(path = "/getAll")
    public ResponseEntity<GetAllItemTagsOutput> getAllTags(@Valid @RequestBody GetAllItemTagsInput input) {

        GetAllItemTagsOutput response = getAllItemTagsOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GetItemTagByIdOutput> getItemTagById(@PathVariable String id) {

        GetItemTagByIdInput input = GetItemTagByIdInput.builder().tagID(id.toString()).build();
       GetItemTagByIdOutput response = getItemTagByIdOperation.process(input);
        return ResponseEntity.ok(response);
    }


    @PatchMapping(path = "/replaceTagName")
    public ResponseEntity<ReplaceTagNameOutput> replaceTagNameOutput(@Valid @RequestBody ReplaceTagNameInput input) {

        ReplaceTagNameOutput response = replaceTagNameOperation.process(input);
        return ResponseEntity.ok(response);
    }

}
