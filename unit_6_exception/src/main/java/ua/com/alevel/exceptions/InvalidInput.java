package ua.com.alevel.exceptions;

public class InvalidInput extends RuntimeException {
    public static final String SECONDS_EXCEPTION = "Incorrect input: Seconds cant be over than \"60\"";
    public static final String MINUTES_EXCEPTION = "Incorrect input: Minutes cant be over than \"60\"";
    public static final String HOURS_EXCEPTION = "Incorrect input: Hours cant be over than \"24\"";
    public static final String DAY_EXCEPTION = "Incorrect input: Day cant be over than \"31\"";
    public static final String MONTH_EXCEPTION = "Incorrect input: Month cant ber over than \"31\"";
    public static final String YEAR_EXCEPTION = "Incorrect input: Year cant be negative";
    public static final String DATE_AND_TIME = "Enter correct date and time!!!";
    public static final String DATE = "Enter correct date!!!";

    public InvalidInput(String msg) {
        super(msg);
    }
}
