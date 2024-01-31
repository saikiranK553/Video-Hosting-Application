package com.maveric.kafka.exception;

public class MediaChannelAlreadyExistsException extends RuntimeException{
    public MediaChannelAlreadyExistsException(String message){
        super(message);
    }
}
