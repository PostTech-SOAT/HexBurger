package br.com.hexburger.dominio.util.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message, null, false, false);
    }

}
