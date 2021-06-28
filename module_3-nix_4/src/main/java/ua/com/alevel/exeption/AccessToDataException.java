package ua.com.alevel.exeption;

public class AccessToDataException extends Exception {

    public AccessToDataException(String message) {
        super(message);
    }

    public AccessToDataException(Throwable cause) {
        super(cause);
    }

    public AccessToDataException(String s, Exception e) {
    }
}
