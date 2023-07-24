package com.example.zoostoreproject.core.exception.vendor;

public class NoSuchVendorException extends RuntimeException{

    private static final String MESSAGE = "No vendor with that public ID!";
    public NoSuchVendorException() {
            super(MESSAGE);}
}
