package app.entities;

public class NoAccessException extends Exception {
    public NoAccessException(String message) {
        super(message);
    }
}