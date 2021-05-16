package ua.com.alevel.firstTask;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatesFormat {

    private static final DateFormat FIRST_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    private static final DateFormat SECOND_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final DateFormat THIRD_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
    private static final DateFormat RESULT_FORMAT = new SimpleDateFormat("yyyyMMdd");

    public static final String FIRST_DATE = "^([0-9][0-9][0-9][0-9])/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$";
    public static final String SECOND_DATE = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/([0-9][0-9][0-9][0-9])$";
    public static final String THIRD_DATE = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-([0-9][0-9][0-9][0-9])$";

    public static List<String> findCorrectDate(List<String> dates){
        List<String> correctDate = new ArrayList<>();
        for (String date : dates) {
            if (isValid(date, FIRST_DATE)) {
                correctDate.add(parseDate(FIRST_FORMAT, date));
            } else if (isValid(date, SECOND_DATE)) {
                correctDate.add(parseDate(SECOND_FORMAT, date));
            } else if (isValid(date, THIRD_DATE)) {
                correctDate.add(parseDate(THIRD_FORMAT, date));
            }
        }
        return correctDate;
    }

    private static String parseDate(DateFormat format, String dateInput){
        String dateResult = null;
        try {
            Date date = format.parse(dateInput);
            dateResult = RESULT_FORMAT.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateResult;
    }
    public static boolean isValid(String date, String datePattern) {
        Pattern pattern = Pattern.compile(datePattern);
        boolean result = false;
        Matcher matcher = pattern.matcher(date);
        if (matcher.matches()) {
            result = true;
        }
        return result;
    }
}
