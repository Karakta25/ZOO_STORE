package com.example.zoostoreproject.core.exception.tag;

public class NoSuchTagException extends RuntimeException{
    private static final String MESSAGE = "No tag with that public ID!";

    public NoSuchTagException() {
        super(MESSAGE);}
}
