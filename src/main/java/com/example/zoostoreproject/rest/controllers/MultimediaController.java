package com.example.zoostoreproject.rest.controllers;

import com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia.AddItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia.AddItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.addItemMultimedia.AddItemMultimediaOperation;
import com.example.zoostoreproject.api.operations.multimedia.getMultiMediaByItemId.GetMultiMediaByItemIdInput;
import com.example.zoostoreproject.api.operations.multimedia.getMultiMediaByItemId.GetMultiMediaByItemIdOutput;
import com.example.zoostoreproject.api.operations.multimedia.getMultiMediaByItemId.GetMultiMediaByItemIdOperation;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaById.GetMultimediaByIdInput;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaById.GetMultimediaByIdOutput;
import com.example.zoostoreproject.api.operations.multimedia.getMultimediaById.GetMultimediaByIdOperation;
import com.example.zoostoreproject.api.operations.multimedia.removeItemMultimedia.RemoveItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.removeItemMultimedia.RemoveItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.removeItemMultimedia.RemoveItemMultimediaOperation;
import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaInput;
import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaOutput;
import com.example.zoostoreproject.api.operations.multimedia.replaceItemMultimedia.ReplaceItemMultimediaOperation;
;
import com.example.zoostoreproject.core.exception.WrongDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequestMapping(path = "/multimedia")
@RequiredArgsConstructor
public class MultimediaController {


    private final AddItemMultimediaOperation addItemMultimediaOperation;
    private final RemoveItemMultimediaOperation removeItemMultimediaOperation;
    private final ReplaceItemMultimediaOperation replaceItemMultimediaOperation;
    private final GetMultiMediaByItemIdOperation getMultiMediaByItemIdOperation;
    private final GetMultimediaByIdOperation getMultimediaByIdOperation;


    @PostMapping(path = "multimedia/add")
    public AddItemMultimediaOutput addItemMultimedia(@RequestBody AddItemMultimediaInput input) throws WrongDataException {
        return addItemMultimediaOperation.process(input);
    }

    @DeleteMapping(path = "multimedia/remove")
    public RemoveItemMultimediaOutput removeItemMultimedia(RemoveItemMultimediaInput input) throws WrongDataException {
        return removeItemMultimediaOperation.process(input);
    }

    @PatchMapping(path = "multimedia/replace")
    public ReplaceItemMultimediaOutput replaceItemMultimedia(ReplaceItemMultimediaInput input) throws WrongDataException {
        return replaceItemMultimediaOperation.process(input);
    }

    @GetMapping(path = "multimedia/getByItemId/{id}")
    public GetMultiMediaByItemIdOutput getMultiMediaByItemId(@RequestParam UUID Id) throws WrongDataException {
        GetMultiMediaByItemIdInput input = GetMultiMediaByItemIdInput.builder()
                .itemID(Id.toString()).build();
        return getMultiMediaByItemIdOperation.process(input);
    }

    @GetMapping(path = "multimedia/getById/{id}")
    public GetMultimediaByIdOutput getMultimediaById(@RequestParam UUID Id) throws WrongDataException {
        GetMultimediaByIdInput input = GetMultimediaByIdInput.builder()
                .mediaID(Id.toString()).build();
        return getMultimediaByIdOperation.process(input);
    }
}
