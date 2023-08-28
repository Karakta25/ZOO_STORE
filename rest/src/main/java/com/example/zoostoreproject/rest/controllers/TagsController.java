package com.example.zoostoreproject.rest.controllers;

import com.example.zoostoreproject.api.operations.tags.add.AddTagInput;
import com.example.zoostoreproject.api.operations.tags.add.AddTagOutput;
import com.example.zoostoreproject.api.operations.tags.add.AddTagOperation;
import com.example.zoostoreproject.api.operations.tags.get.alltags.GetAllItemTagsInput;
import com.example.zoostoreproject.api.operations.tags.get.alltags.GetAllItemTagsOutput;
import com.example.zoostoreproject.api.operations.tags.get.alltags.GetAllItemTagsOperation;
import com.example.zoostoreproject.api.operations.tags.get.byid.GetItemTagByIdInput;
import com.example.zoostoreproject.api.operations.tags.get.byid.GetItemTagByIdOutput;
import com.example.zoostoreproject.api.operations.tags.get.byid.GetItemTagByIdOperation;
import com.example.zoostoreproject.api.operations.tags.get.bytitle.GetItemTagByTitleInput;
import com.example.zoostoreproject.api.operations.tags.get.bytitle.GetItemTagByTitleOperation;
import com.example.zoostoreproject.api.operations.tags.get.bytitle.GetItemTagByTitleOutput;
import com.example.zoostoreproject.api.operations.tags.remove.RemoveItemTagsInput;
import com.example.zoostoreproject.api.operations.tags.remove.RemoveItemTagsOutput;
import com.example.zoostoreproject.api.operations.tags.remove.RemoveItemTagsOperation;
import com.example.zoostoreproject.api.operations.tags.replacename.ReplaceTagNameInput;
import com.example.zoostoreproject.api.operations.tags.replacename.ReplaceTagNameOutput;
import com.example.zoostoreproject.api.operations.tags.replacename.ReplaceTagNameOperation;

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
    private final GetItemTagByTitleOperation getItemTagByTitleOperation;


    @PostMapping()
    public ResponseEntity<AddTagOutput> addItemTag(@Valid @RequestBody AddTagInput input)  {

        AddTagOutput response = addTagOperation.process(input);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<GetItemTagByTitleOutput> getItemTagByTagTitle(@PathVariable String title)  {

        GetItemTagByTitleInput input = GetItemTagByTitleInput.builder().tagTitle(title).build();
        GetItemTagByTitleOutput response = getItemTagByTitleOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping()
    public ResponseEntity<RemoveItemTagsOutput> removeItemTag(@Valid @RequestBody RemoveItemTagsInput input)  {

        RemoveItemTagsOutput response = removeItemTagsOperation.process(input);
        return ResponseEntity.ok(response);
    }


    @PostMapping(path = "/getAll")
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
