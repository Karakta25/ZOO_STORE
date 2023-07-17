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

import com.example.zoostoreproject.core.exception.WrongDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequestMapping(path = "/vendors")
@RequiredArgsConstructor
public class VendorController {


    private final AddVendorOperation addVendorOperation;
    private final RemoveVendorOperation removeVendorOperation;
    private final EditVendorNameOperation editVendorNameOperation;
    private final EditVendorPhoneOperation editVendorPhoneOperation;
    private final GetAllVendorsOperation getAllVendorsOperation;
    private final GetVendorByIdOperation getVendorByIdOperation;


    @PostMapping(path = "vendor/add")
    public AddVendorOutput addVendor(@RequestBody AddVendorInput input) throws WrongDataException {
        return addVendorOperation.process(input);
    }


    @DeleteMapping(path = "vendor/remove")
    public RemoveVendorOutput removeVendor(RemoveVendorInput input) throws WrongDataException {
        return removeVendorOperation.process(input);
    }

    @PatchMapping(path = "vendor/editName")
    public EditVendorNameOutput editVendorName(EditVendorNameInput input) throws WrongDataException {
        return editVendorNameOperation.process(input);
    }
    @PatchMapping(path = "vendor/editPhone")
    public EditVendorPhoneOutput editVendorPhone(EditVendorPhoneInput input) throws WrongDataException {
        return editVendorPhoneOperation.process(input);
    }

    @GetMapping(path = "vendor/getAll")
    public GetAllVendorsOutput getAllVendors(GetAllVendorsInput input) throws WrongDataException {
        return getAllVendorsOperation.process(input);
    }

    @GetMapping(path = "vendor/getById/{id}")
    public GetVendorByIdOutput getVendorById(@RequestParam UUID Id) throws WrongDataException {
        GetVendorByIdInput input = GetVendorByIdInput.builder().id(Id.toString()).build();
        return getVendorByIdOperation.process(input);
    }

}
