package com.example.zoostoreproject.api.operations.base;

public interface OperationProcessor<I extends OperationInput, R extends OperationResult>{

    public R process(I input);
}
