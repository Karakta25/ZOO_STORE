package com.example.zoostoreproject.rest.controllers;

import com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia.AddItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia.AddItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia.AddItemMultimediaOperation;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaByItemId.GetMultimediaByItemIdInput;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaByItemId.GetMultimediaByItemIdOutput;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaByItemId.GetMultimediaByItemIdOperation;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaById.GetMultimediaByIdInput;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaById.GetMultimediaByIdOutput;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaById.GetMultimediaByIdOperation;
import com.example.zoostoreproject.api.operations.multimedia.removeItemMultimedia.RemoveItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.removeItemMultimedia.RemoveItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.removeItemMultimedia.RemoveItemMultimediaOperation;
import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaOperation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/multimedia")
@RequiredArgsConstructor
public class MultimediaController {


    private final AddItemMultimediaOperation addItemMultimediaOperation;
    private final RemoveItemMultimediaOperation removeItemMultimediaOperation;
    private final ReplaceItemMultimediaOperation replaceItemMultimediaOperation;
    private final GetMultimediaByItemIdOperation getMultiMediaByItemIdOperation;
    private final GetMultimediaByIdOperation getMultimediaByIdOperation;


    @PostMapping()
    public ResponseEntity<AddItemMultimediaOutput> addItemMultimedia(@Valid @RequestBody AddItemMultimediaInput input){

        AddItemMultimediaOutput response = addItemMultimediaOperation.process(input);
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping()
    public ResponseEntity<RemoveItemMultimediaOutput> removeItemMultimedia(@Valid @RequestBody RemoveItemMultimediaInput input){

        RemoveItemMultimediaOutput response =  removeItemMultimediaOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/replace")
    public ResponseEntity<ReplaceItemMultimediaOutput> replaceItemMultimedia(@Valid @RequestBody ReplaceItemMultimediaInput input) {

        ReplaceItemMultimediaOutput response = replaceItemMultimediaOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/item/{itemID}")
    public ResponseEntity<GetMultimediaByItemIdOutput> getMultiMediaByItemId(@RequestParam UUID Id)  {

        GetMultimediaByItemIdInput input = GetMultimediaByItemIdInput.builder()
                .itemID(Id.toString()).build();
        GetMultimediaByItemIdOutput response = getMultiMediaByItemIdOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{mediaID}")
    public ResponseEntity<GetMultimediaByIdOutput> getMultimediaById(@RequestParam UUID Id){

        GetMultimediaByIdInput input = GetMultimediaByIdInput.builder()
                .mediaID(Id.toString()).build();
        GetMultimediaByIdOutput response = getMultimediaByIdOperation.process(input);
        return ResponseEntity.ok(response);
    }
}
