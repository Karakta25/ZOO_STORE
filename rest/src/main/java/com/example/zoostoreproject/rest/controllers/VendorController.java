package com.example.zoostoreproject.rest.controllers;


import com.example.zoostoreproject.api.operations.vendor.add.AddVendorInput;
import com.example.zoostoreproject.api.operations.vendor.add.AddVendorOutput;
import com.example.zoostoreproject.api.operations.vendor.add.AddVendorOperation;
import com.example.zoostoreproject.api.operations.vendor.editproperties.EditVendorPropertiesInput;
import com.example.zoostoreproject.api.operations.vendor.editproperties.EditVendorPropertiesOperation;
import com.example.zoostoreproject.api.operations.vendor.editproperties.EditVendorPropertiesOutput;
import com.example.zoostoreproject.api.operations.vendor.get.allvendors.GetAllVendorsInput;
import com.example.zoostoreproject.api.operations.vendor.get.allvendors.GetAllVendorsOutput;
import com.example.zoostoreproject.api.operations.vendor.get.allvendors.GetAllVendorsOperation;
import com.example.zoostoreproject.api.operations.vendor.get.byid.GetVendorByIdInput;
import com.example.zoostoreproject.api.operations.vendor.get.byid.GetVendorByIdOutput;
import com.example.zoostoreproject.api.operations.vendor.get.byid.GetVendorByIdOperation;
import com.example.zoostoreproject.api.operations.vendor.remove.RemoveVendorInput;
import com.example.zoostoreproject.api.operations.vendor.remove.RemoveVendorOutput;
import com.example.zoostoreproject.api.operations.vendor.remove.RemoveVendorOperation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/vendor")
@RequiredArgsConstructor
public class VendorController {


    private final AddVendorOperation addVendorOperation;
    private final RemoveVendorOperation removeVendorOperation;
    private final EditVendorPropertiesOperation editVendorPropertiesOperation;
    private final GetAllVendorsOperation getAllVendorsOperation;
    private final GetVendorByIdOperation getVendorByIdOperation;


    @PostMapping
    public ResponseEntity<AddVendorOutput> addVendor(@RequestBody AddVendorInput input)  {

        AddVendorOutput response =  addVendorOperation.process(input);
        return ResponseEntity.status(201).body(response);
    }


    @DeleteMapping
    public ResponseEntity<RemoveVendorOutput> removeVendor(@Valid @RequestBody RemoveVendorInput input) {
        RemoveVendorOutput response = removeVendorOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "properties")
    public ResponseEntity<EditVendorPropertiesOutput> editVendorProperties(@Valid @RequestBody EditVendorPropertiesInput input) {
        EditVendorPropertiesOutput response = editVendorPropertiesOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<GetAllVendorsOutput> getAllVendors() {
        GetAllVendorsOutput response = getAllVendorsOperation.process(GetAllVendorsInput.builder().build());
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{vendorID}")
    public ResponseEntity<GetVendorByIdOutput> getVendorById(@RequestParam @NotNull UUID Id) {
        GetVendorByIdInput input = GetVendorByIdInput.builder().id(Id.toString()).build();
        GetVendorByIdOutput response = getVendorByIdOperation.process(input);
        return ResponseEntity.ok(response);
    }

}
