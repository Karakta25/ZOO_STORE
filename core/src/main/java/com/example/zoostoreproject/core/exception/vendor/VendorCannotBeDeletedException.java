package com.example.zoostoreproject.core.exception.vendor;

public class VendorCannotBeDeletedException extends RuntimeException {
    private static final String MESSAGE = "No vendor with that public ID!";
    public VendorCannotBeDeletedException() {
        super(MESSAGE);}
}
