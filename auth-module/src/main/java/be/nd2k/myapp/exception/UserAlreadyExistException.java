package be.nd2k.myapp.exception;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
