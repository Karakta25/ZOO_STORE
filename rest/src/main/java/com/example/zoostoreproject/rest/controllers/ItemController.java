package com.example.zoostoreproject.rest.controllers;

import com.example.zoostoreproject.api.operations.item.addtag.AddTagToItemInput;
import com.example.zoostoreproject.api.operations.item.addtag.AddTagToItemOperation;
import com.example.zoostoreproject.api.operations.item.addtag.AddTagToItemOutput;
import com.example.zoostoreproject.api.operations.item.archive.ArchiveItemInput;
import com.example.zoostoreproject.api.operations.item.archive.ArchiveItemOutput;
import com.example.zoostoreproject.api.operations.item.archive.ArchiveItemOperation;
import com.example.zoostoreproject.api.operations.item.create.CreateItemInput;
import com.example.zoostoreproject.api.operations.item.create.CreateItemOutput;
import com.example.zoostoreproject.api.operations.item.create.CreateItemOperation;
import com.example.zoostoreproject.api.operations.item.editproperties.EditItemPropertiesInput;
import com.example.zoostoreproject.api.operations.item.editproperties.EditItemPropertiesOperation;
import com.example.zoostoreproject.api.operations.item.editproperties.EditItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.item.get.allitems.GetAllItemsListInput;
import com.example.zoostoreproject.api.operations.item.get.allitems.GetAllItemsListOutput;
import com.example.zoostoreproject.api.operations.item.get.allitems.GetAllItemsOperation;
import com.example.zoostoreproject.api.operations.cartitem.getproperties.GetCartItemPropertiesInput;
import com.example.zoostoreproject.api.operations.cartitem.getproperties.GetCartItemPropertiesOperation;
import com.example.zoostoreproject.api.operations.cartitem.getproperties.GetCartItemPropertiesOutput;
import com.example.zoostoreproject.api.operations.item.get.bydescription.GetItemByDescriptionInput;
import com.example.zoostoreproject.api.operations.item.get.bydescription.GetItemByDescriptionOperation;
import com.example.zoostoreproject.api.operations.item.get.byid.GetItemByIdInput;
import com.example.zoostoreproject.api.operations.item.get.byid.GetItemByIdOperation;
import com.example.zoostoreproject.api.operations.item.get.byid.GetItemByIdOutput;
import com.example.zoostoreproject.api.operations.item.get.bydescription.GetItemByDescriptionOutput;
import com.example.zoostoreproject.api.operations.item.get.bytagtitle.GetItemsIdByTagTitleInput;
import com.example.zoostoreproject.api.operations.item.get.bytagtitle.GetItemsIdByTagTitleOperation;
import com.example.zoostoreproject.api.operations.item.get.bytagtitle.GetItemsIdByTagTitleOutput;
import com.example.zoostoreproject.api.operations.item.removetag.RemoveTagFromItemInput;
import com.example.zoostoreproject.api.operations.item.removetag.RemoveTagFromItemOperation;
import com.example.zoostoreproject.api.operations.item.removetag.RemoveTagFromItemOutput;
import com.example.zoostoreproject.api.operations.item.warrantycardvalidation.WarrantyCardValidationInput;
import com.example.zoostoreproject.api.operations.item.warrantycardvalidation.WarrantyCardValidationOperation;
import com.example.zoostoreproject.api.operations.item.warrantycardvalidation.WarrantyCardValidationOutput;
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
    private final GetItemsIdByTagTitleOperation getItemsIdByTagTitleOperation;
    private final GetItemByDescriptionOperation getItemByDescriptionOperation;
    private final GetCartItemPropertiesOperation getCartItemPropertiesOperation;
    private final WarrantyCardValidationOperation warrantyCardValidationOperation;


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
    public ResponseEntity<GetAllItemsListOutput> getAllItems() {

        GetAllItemsListOutput response = getAllItemsOperation.process(GetAllItemsListInput.builder().build());
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GetItemByIdOutput> getItemByIdById(@PathVariable String id) {
        GetItemByIdInput input = GetItemByIdInput.builder().id(id).build();
        GetItemByIdOutput response = getItemByIdOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/cartItemProperties")
    public ResponseEntity<GetCartItemPropertiesOutput> getCartItemProperties(@Valid @RequestBody GetCartItemPropertiesInput input) {
        GetCartItemPropertiesOutput response = getCartItemPropertiesOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/warrantyValidation")
    public ResponseEntity<WarrantyCardValidationOutput> warrantyValidation(@Valid @RequestBody WarrantyCardValidationInput input) {
        WarrantyCardValidationOutput response = warrantyCardValidationOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/byTagTitle")
    public ResponseEntity<GetItemsIdByTagTitleOutput> getItemByTitleTag(@Valid @RequestBody GetItemsIdByTagTitleInput input) {
        GetItemsIdByTagTitleOutput response= getItemsIdByTagTitleOperation.process(input);
        return ResponseEntity.ok(response);
    }
    @PostMapping(path = "/description")
    public ResponseEntity<GetItemByDescriptionOutput> getItemByDescriptionRegex(@Valid @RequestBody GetItemByDescriptionInput input){

        GetItemByDescriptionOutput response = getItemByDescriptionOperation.process(input);
        return ResponseEntity.ok(response);
    }

}

