package com.example.zoostoreproject.core.exception.multimedia;

public class NoSuchMultimediaException extends RuntimeException{
    private static final String MESSAGE = "No multimedia with that public ID!";

    public NoSuchMultimediaException() {
        super(MESSAGE);}
}
