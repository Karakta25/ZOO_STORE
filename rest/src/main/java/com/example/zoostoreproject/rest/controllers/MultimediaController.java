package com.example.zoostoreproject.rest.controllers;

import com.example.zoostoreproject.api.operations.multimedia.add.AddItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.add.AddItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.add.AddItemMultimediaOperation;
import com.example.zoostoreproject.api.operations.multimedia.get.byitemid.GetMultimediaByItemIdInput;
import com.example.zoostoreproject.api.operations.multimedia.get.byitemid.GetMultimediaByItemIdOutput;
import com.example.zoostoreproject.api.operations.multimedia.get.byitemid.GetMultimediaByItemIdOperation;
import com.example.zoostoreproject.api.operations.multimedia.get.byid.GetMultimediaByIdInput;
import com.example.zoostoreproject.api.operations.multimedia.get.byid.GetMultimediaByIdOutput;
import com.example.zoostoreproject.api.operations.multimedia.get.byid.GetMultimediaByIdOperation;
import com.example.zoostoreproject.api.operations.multimedia.remove.RemoveItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.remove.RemoveItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.remove.RemoveItemMultimediaOperation;
import com.example.zoostoreproject.api.operations.multimedia.replace.ReplaceItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.replace.ReplaceItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.replace.ReplaceItemMultimediaOperation;

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
