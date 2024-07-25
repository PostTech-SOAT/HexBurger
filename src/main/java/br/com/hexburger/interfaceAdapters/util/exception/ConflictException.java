package br.com.hexburger.interfaceAdapters.util.exception;

public class ConflictException extends RuntimeException {

    public ConflictException(String message) {
        super(message, null, false, false);
    }
}
