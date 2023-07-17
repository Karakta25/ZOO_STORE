package com.example.zoostoreproject.api.operations.base;

import com.example.zoostoreproject.core.exception.WrongDataException;

public interface OperationProcessor<I extends OperationInput, R extends OperationResult>{

    public R process(I input) throws WrongDataException;
}
