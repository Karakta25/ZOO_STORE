package com.example.zoostoreproject.rest.controllers;


import com.example.zoostoreproject.api.operations.vendor.addVendor.AddVendorInput;
import com.example.zoostoreproject.api.operations.vendor.addVendor.AddVendorOutput;
import com.example.zoostoreproject.api.operations.vendor.addVendor.AddVendorOperation;
import com.example.zoostoreproject.api.operations.vendor.editVendorName.EditVendorNameInput;
import com.example.zoostoreproject.api.operations.vendor.editVendorName.EditVendorNameOutput;
import com.example.zoostoreproject.api.operations.vendor.editVendorName.EditVendorNameOperation;
import com.example.zoostoreproject.api.operations.vendor.editVendorPhone.EditVendorPhoneInput;
import com.example.zoostoreproject.api.operations.vendor.editVendorPhone.EditVendorPhoneOutput;
import com.example.zoostoreproject.api.operations.vendor.editVendorPhone.EditVendorPhoneOperation;
import com.example.zoostoreproject.api.operations.vendor.getAllVendors.GetAllVendorsInput;
import com.example.zoostoreproject.api.operations.vendor.getAllVendors.GetAllVendorsOutput;
import com.example.zoostoreproject.api.operations.vendor.getAllVendors.GetAllVendorsOperation;
import com.example.zoostoreproject.api.operations.vendor.getVendorById.GetVendorByIdInput;
import com.example.zoostoreproject.api.operations.vendor.getVendorById.GetVendorByIdOutput;
import com.example.zoostoreproject.api.operations.vendor.getVendorById.GetVendorByIdOperation;
import com.example.zoostoreproject.api.operations.vendor.removeVendor.RemoveVendorInput;
import com.example.zoostoreproject.api.operations.vendor.removeVendor.RemoveVendorOutput;
import com.example.zoostoreproject.api.operations.vendor.removeVendor.RemoveVendorOperation;

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
    private final EditVendorNameOperation editVendorNameOperation;
    private final EditVendorPhoneOperation editVendorPhoneOperation;
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

    @PatchMapping(path = "name")
    public ResponseEntity<EditVendorNameOutput> editVendorName(@Valid @RequestBody EditVendorNameInput input) {
        EditVendorNameOutput response = editVendorNameOperation.process(input);
        return ResponseEntity.ok(response);
    }
    @PatchMapping(path = "phone")
    public ResponseEntity<EditVendorPhoneOutput> editVendorPhone(@Valid @RequestBody EditVendorPhoneInput input)  {
        EditVendorPhoneOutput response = editVendorPhoneOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<GetAllVendorsOutput> getAllVendors(@Valid @RequestBody GetAllVendorsInput input) {
        GetAllVendorsOutput response = getAllVendorsOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{vendorID}")
    public ResponseEntity<GetVendorByIdOutput> getVendorById(@RequestParam @NotNull UUID Id) {
        GetVendorByIdInput input = GetVendorByIdInput.builder().id(Id.toString()).build();
        GetVendorByIdOutput response = getVendorByIdOperation.process(input);
        return ResponseEntity.ok(response);
    }

}
