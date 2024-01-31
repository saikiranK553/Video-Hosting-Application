package com.maveric.kafka.exception;

public class AlreadySubscribedtoChannelException extends RuntimeException{
    public AlreadySubscribedtoChannelException(String message){
        super(message);
    }
}
