package com.org.irctc.exception;

public class InvalidEntityException extends RuntimeException{
    public InvalidEntityException(String message){
        super(message);
    }
}
