package br.com.hexburger.application.util.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message, null, false, false);
    }

}
