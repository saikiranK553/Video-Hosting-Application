package com.maveric.kafka.exception;

public class MediaChannelNotFoundException extends  RuntimeException{
    public MediaChannelNotFoundException(String message){
        super(message);
    }
}
