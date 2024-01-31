package com.maveric.kafka.exception;

public class DuplicateVideoNameException extends RuntimeException{
    public DuplicateVideoNameException(String message){
        super(message);
    }
}
