package com.example.zoostoreproject.rest.controllers;

import com.example.zoostoreproject.api.operations.item.addTagToItem.AddTagToItemInput;
import com.example.zoostoreproject.api.operations.item.addTagToItem.AddTagToItemOperation;
import com.example.zoostoreproject.api.operations.item.addTagToItem.AddTagToItemOutput;
import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemInput;
import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemOutput;
import com.example.zoostoreproject.api.operations.item.archiveItem.ArchiveItemOperation;
import com.example.zoostoreproject.api.operations.item.createItem.CreateItemInput;
import com.example.zoostoreproject.api.operations.item.createItem.CreateItemOutput;
import com.example.zoostoreproject.api.operations.item.createItem.CreateItemOperation;
import com.example.zoostoreproject.api.operations.item.editItemDescription.EditDescriptionInput;
import com.example.zoostoreproject.api.operations.item.editItemDescription.EditDescriptionOperation;
import com.example.zoostoreproject.api.operations.item.editItemDescription.EditDescriptionOutput;
import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameInput;
import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameOutput;
import com.example.zoostoreproject.api.operations.item.editItemProductName.EditProductNameOperation;
import com.example.zoostoreproject.api.operations.item.editItemVendorId.EditVendorIdInput;
import com.example.zoostoreproject.api.operations.item.editItemVendorId.EditVendorIdOperation;
import com.example.zoostoreproject.api.operations.item.editItemVendorId.EditVendorIdOutput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsListInput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsListOutput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsOperation;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdInput;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdOperation;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdOutput;

import com.example.zoostoreproject.api.operations.item.removeTagFromItem.RemoveTagFromItemInput;
import com.example.zoostoreproject.api.operations.item.removeTagFromItem.RemoveTagFromItemOperation;
import com.example.zoostoreproject.api.operations.item.removeTagFromItem.RemoveTagFromItemOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/item")
@RequiredArgsConstructor
public class ItemController {


    private final CreateItemOperation createItemOperation;
    private final ArchiveItemOperation archiveItemOperation;
    private final EditProductNameOperation editProductNameOperation;
    private final EditDescriptionOperation editDescriptionOperation;
    private final EditVendorIdOperation editVendorIdOperation;
    private final AddTagToItemOperation addTagToItemOperation;
    private final RemoveTagFromItemOperation removeTagFromItemOperation;
    private final GetAllItemsOperation getAllItemsOperation;
    private final GetItemByIdOperation getItemByIdOperation;


    @PostMapping()
    @Operation ()
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})


    public ResponseEntity<CreateItemOutput> createItem(@Valid @RequestBody CreateItemInput input)  {
       CreateItemOutput response = createItemOperation.process(input);
        return ResponseEntity.status(201).body(response);
    }

    @PatchMapping(path = "/archiveStatus")
    public ResponseEntity<ArchiveItemOutput> archiveItem(@Valid @RequestBody ArchiveItemInput input)  {
        ArchiveItemOutput response = archiveItemOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/productName")
    public ResponseEntity<EditProductNameOutput> editProductName(@Valid @RequestBody EditProductNameInput input)  {
        EditProductNameOutput response = editProductNameOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/description")
    public ResponseEntity<EditDescriptionOutput> editDescription(@Valid @RequestBody EditDescriptionInput input)  {
        EditDescriptionOutput response = editDescriptionOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/vendorId")
    public ResponseEntity<EditVendorIdOutput> editVendorId(@Valid @RequestBody EditVendorIdInput input) {
        EditVendorIdOutput response = editVendorIdOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/addTagToItem")
    public ResponseEntity<AddTagToItemOutput> addTagToItem(@Valid @RequestBody AddTagToItemInput input)  {
        AddTagToItemOutput response = addTagToItemOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/removeTagFromItem")
    public ResponseEntity<RemoveTagFromItemOutput> removeTagFromItem(@Valid @RequestBody RemoveTagFromItemInput input) {
        RemoveTagFromItemOutput response = removeTagFromItemOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @Operation(description = "Returns list of all items", summary = "Get all items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})
    @GetMapping(path = "/getAll")
    public ResponseEntity<GetAllItemsListOutput> getAllItems(@Valid @RequestBody GetAllItemsListInput input) {

       GetAllItemsListOutput response = getAllItemsOperation.process(input);
       return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{itemID}")
    public ResponseEntity<GetItemByIdOutput> getItemByIdById(@PathVariable String id)  {
        GetItemByIdInput input = GetItemByIdInput.builder().id(id).build();
        GetItemByIdOutput response = getItemByIdOperation.process(input);
        return ResponseEntity.ok(response);
    }

}

