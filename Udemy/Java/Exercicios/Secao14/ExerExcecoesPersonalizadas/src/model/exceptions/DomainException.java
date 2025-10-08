package model.exceptions;

// Exception obriga você à tratar a exceção e RuntimeException não obriga.
public class DomainException extends Exception {
    public DomainException(String message) {
        super(message);
    }
}
