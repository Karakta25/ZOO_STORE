package com.example.zoostoreproject.api.operations.base;


import java.lang.invoke.WrongMethodTypeException;

public interface OperationProcessor<I extends OperationInput, R extends OperationResult>{

    public R process(I input);
}
