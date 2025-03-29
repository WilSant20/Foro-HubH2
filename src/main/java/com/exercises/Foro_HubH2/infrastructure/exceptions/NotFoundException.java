package com.exercises.Foro_HubH2.infrastructure.exceptions;

public abstract class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
    public abstract String getResourceName();
}
