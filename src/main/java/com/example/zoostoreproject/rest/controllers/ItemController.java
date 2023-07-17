package com.example.zoostoreproject.rest.controllers;



import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemInput;
import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemOutput;
import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemOperation;
import com.example.zoostoreproject.api.operations.item.createItem.CreateItemInput;
import com.example.zoostoreproject.api.operations.item.createItem.CreateItemOutput;
import com.example.zoostoreproject.api.operations.item.createItem.CreateItemOperation;
import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameInput;
import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameOutput;
import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameOperation;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsListInput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsListOutput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsOperation;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdInput;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdOperation;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdOutput;

import com.example.zoostoreproject.core.exception.WrongDataException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequestMapping(path = "/items")
@RequiredArgsConstructor
public class ItemController {


    private final CreateItemOperation createItemOperation;
    private final ArchiveItemOperation archiveItemOperation;
    private final EditProductNameOperation editProductNameOperation;
    private final GetAllItemsOperation getAllItemsOperation;
    private final GetItemByIdOperation getItemByIdOperation;


    @PostMapping(path = "/item/create")
    @Operation ()
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})



    public CreateItemOutput createItem(@RequestBody CreateItemInput input) throws WrongDataException {
        return createItemOperation.process(input);
    }

    @PatchMapping(path = "/item/archive")
    public ArchiveItemOutput archiveItem(@RequestBody ArchiveItemInput input) throws WrongDataException {
        return archiveItemOperation.process(input);
    }

    @PatchMapping(path = "item/edit")
    public EditProductNameOutput editProductName(@RequestBody EditProductNameInput input) throws WrongDataException {
        return editProductNameOperation.process(input);
    }

    @Operation(description = "Returns list of all items", summary = "Get all items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})
    @GetMapping(path = "/item/getAll")
    public GetAllItemsListOutput getAllItems(@RequestBody GetAllItemsListInput input) throws WrongDataException {

        return getAllItemsOperation.process(input);
    }

    @GetMapping(path = "item/getById/{id}")
    public GetItemByIdOutput getItemByIdById(@RequestParam UUID Id) throws WrongDataException {
        GetItemByIdInput input = GetItemByIdInput.builder().id(Id.toString()).build();
        return getItemByIdOperation.process(input);
    }

}

