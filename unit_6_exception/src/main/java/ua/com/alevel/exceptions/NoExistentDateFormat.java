package ua.com.alevel.exceptions;

public class NoExistentDateFormat extends RuntimeException {

    public static final String NON_EXISTENT_DATE_FORMAT = "The format you entered does not match the one you selected";
    public NoExistentDateFormat(String msg) {
        super(msg);
    }
}
