package com.example.zoostoreproject.api.operations.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReturnsOrReplacementReasons {

    DEFECTIVEITEM ("Defective Item"),
    WRONGITEMSHIPPED("Wrong Item Shipped"),
    SIZEORFITISSUES("Size or Fit issues"),
    CHANGEOFMIND("Change of Mind"),
    UNSATISFACTORYPERFORMANCE("Unsatisfactory Performance");

    private final String name;

 }
