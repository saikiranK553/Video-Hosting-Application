package com.maveric.kafka.controller;

import com.maveric.kafka.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MediaChannelNotFoundException.class)
    public String handleMediaChannelNotFoundException(MediaChannelNotFoundException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MediaChannelAlreadyExistsException.class)
    public String handleMediaChannelAlreadyExitsException(MediaChannelAlreadyExistsException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public String handleEmailAlreadyExistsException(EmailAlreadyExistsException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SubscriberNotFoundException.class)
    public String handleSubscriberNotFoundException(SubscriberNotFoundException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlreadySubscribedtoChannelException.class)
    public String handleAlreadySubscribedException(AlreadySubscribedtoChannelException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateVideoNameException.class)
    public String handleMediaChannelNotFoundException(DuplicateVideoNameException e){
        return e.getMessage();
    }


}
