package com.packt.todo.exception;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message) {
        super(message);  
    }
    
}
