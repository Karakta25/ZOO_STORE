package com.example.zoostoreproject.core.item.warrantycardvalidation;

import com.example.zoostoreproject.api.operations.item.ItemOperations;
import com.example.zoostoreproject.api.operations.item.ReturnsOrReplacementReasons;
import com.example.zoostoreproject.api.operations.item.warrantycardvalidation.WarrantyCardValidationInput;
import com.example.zoostoreproject.api.operations.item.warrantycardvalidation.WarrantyCardValidationOperation;
import com.example.zoostoreproject.api.operations.item.warrantycardvalidation.WarrantyCardValidationOutput;
import com.example.zoostoreproject.core.exception.item.NoSuchItemException;
import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.repositories.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.UUID;
@Slf4j
@Service
@RequiredArgsConstructor
public class WarrantyCardOperationProcessor implements WarrantyCardValidationOperation {

    private final ItemRepository itemRepository;

    @Override
    public WarrantyCardValidationOutput process(WarrantyCardValidationInput input) {


        Item item = itemRepository.findById(UUID.fromString(input.getItemId()))
                .orElseThrow(NoSuchItemException::new);

        boolean validOperation = Arrays.stream(ItemOperations.values())
                .anyMatch(operation -> operation.name().equalsIgnoreCase(input.getOperation()));

        boolean validFeedback = Arrays.stream(ReturnsOrReplacementReasons.values())
                .anyMatch(reason -> reason.getName().equalsIgnoreCase(input.getFeedback()));

        if (validOperation && (validFeedback || input.getOperation().equalsIgnoreCase(ItemOperations.REPAIR.toString())))
            {
                return WarrantyCardValidationOutput
                        .builder()
                        .operation(input.getOperation())
                        .success(true)
                        .warrantyPeriod(item.getWarrantyPeriod())
                        .build();
            }

            return WarrantyCardValidationOutput
                    .builder()
                    .operation("Invalid Operation or Description")
                    .success(false)
                    .warrantyPeriod(0)
                    .build();

    }
}
