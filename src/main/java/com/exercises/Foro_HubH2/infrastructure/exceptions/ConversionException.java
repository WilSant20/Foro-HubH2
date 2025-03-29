package com.exercises.Foro_HubH2.infrastructure.exceptions;

import java.lang.invoke.LambdaConversionException;

public class ConversionException extends RuntimeException{
    public ConversionException(String message) {
        super(message);
    }
}
