package com.maveric.kafka.exception;

public class SubscriberNotFoundException extends RuntimeException{
    public SubscriberNotFoundException(String message){
        super(message);
    }
}
