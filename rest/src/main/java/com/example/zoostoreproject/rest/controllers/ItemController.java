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
import com.example.zoostoreproject.api.operations.item.editItemProperties.EditItemPropertiesInput;
import com.example.zoostoreproject.api.operations.item.editItemProperties.EditItemPropertiesOperation;
import com.example.zoostoreproject.api.operations.item.editItemProperties.EditItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsListInput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsListOutput;
import com.example.zoostoreproject.api.operations.item.getAllItems.GetAllItemsOperation;
import com.example.zoostoreproject.api.operations.item.getCartItemProperties.GetCartItemPropertiesInput;
import com.example.zoostoreproject.api.operations.item.getCartItemProperties.GetCartItemPropertiesOperation;
import com.example.zoostoreproject.api.operations.item.getCartItemProperties.GetCartItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.item.getItemByDescription.GetItemByDescriptionInput;
import com.example.zoostoreproject.api.operations.item.getItemByDescription.GetItemByDescriptionOperation;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdInput;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdOperation;
import com.example.zoostoreproject.api.operations.item.getItemById.GetItemByIdOutput;
import com.example.zoostoreproject.api.operations.item.getItemByDescription.GetItemByDescriptionOutput;
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

@RestController
@RequestMapping(path = "/item")
@RequiredArgsConstructor
public class ItemController {


    private final CreateItemOperation createItemOperation;
    private final ArchiveItemOperation archiveItemOperation;
    private final EditItemPropertiesOperation editItemPropertiesOperation;
    private final AddTagToItemOperation addTagToItemOperation;
    private final RemoveTagFromItemOperation removeTagFromItemOperation;
    private final GetAllItemsOperation getAllItemsOperation;
    private final GetItemByIdOperation getItemByIdOperation;
    private final GetItemByDescriptionOperation getItemByDescriptionOperation;
    private final GetCartItemPropertiesOperation getCartItemPropertiesOperation;


    @PostMapping()
    @Operation()
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})


    public ResponseEntity<CreateItemOutput> createItem(@Valid @RequestBody CreateItemInput input) {
        CreateItemOutput response = createItemOperation.process(input);
        return ResponseEntity.status(201).body(response);
    }

    @PatchMapping(path = "/archiveStatus")
    public ResponseEntity<ArchiveItemOutput> archiveItem(@Valid @RequestBody ArchiveItemInput input) {
        ArchiveItemOutput response = archiveItemOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/properties")
    public ResponseEntity<EditItemPropertiesOutput> editItemProperties(@Valid @RequestBody EditItemPropertiesInput input) {
        EditItemPropertiesOutput response = editItemPropertiesOperation.process(input);
        return ResponseEntity.ok(response);
    }


    @PatchMapping(path = "/addTagToItem")
    public ResponseEntity<AddTagToItemOutput> addTagToItem(@Valid @RequestBody AddTagToItemInput input) {
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<GetItemByIdOutput> getItemByIdById(@PathVariable String id) {
        GetItemByIdInput input = GetItemByIdInput.builder().id(id).build();
        GetItemByIdOutput response = getItemByIdOperation.process(input);
        return ResponseEntity.ok(response);
    }
    @PostMapping(path = "/{cartItemProperties}")
    public ResponseEntity<GetCartItemPropertiesOutput> getCartItemProperties(@Valid @RequestBody GetCartItemPropertiesInput input) {
        GetCartItemPropertiesOutput response = getCartItemPropertiesOperation.process(input);
        return ResponseEntity.ok(response);
    }
    @GetMapping(path = "/tagTitle")
    public ResponseEntity<GetItemByDescriptionOutput> getItemByTitleTag(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "itemsPerPage") Integer itemsPerPage,
            @RequestParam(name = "currentPage") Integer currentPage) {

        GetItemByDescriptionInput input = GetItemByDescriptionInput.builder()
                .regex(title)
                .itemCount(itemsPerPage)
                .page(currentPage)
                .build();

        GetItemByDescriptionOutput response = getItemByDescriptionOperation.process(input);
        return ResponseEntity.ok(response);
    }

}

