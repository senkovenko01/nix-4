package ua.com.alevel.services;

import ua.com.alevel.entity.Month;
import ua.com.alevel.exceptions.InvalidInput;
import ua.com.alevel.exceptions.NoExistentDateFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputService {
    private String format;
    private final Scanner scanner = new Scanner(System.in);

    public void setFormat(String format) {
        if (format.replaceAll("[dm/y0:\\- ]", "").length() != 0) {
            throw new NoExistentDateFormat(NoExistentDateFormat.NON_EXISTENT_DATE_FORMAT);
        }
        Map<Character, Integer> map = new HashMap<>();
        for ( int i = 0; i < format.length(); i++ ) {
            Integer n = map.get( format.charAt(i) );
            if ( n == null ) map.put( format.charAt(i), 1 );
            else map.put( format.charAt(i), ++n );
        }
        if (!format.contains("/") && !format.contains("-")) {
            throw new NoExistentDateFormat(NoExistentDateFormat.NON_EXISTENT_DATE_FORMAT);
        }
        if (format.contains("/")) {
            if (map.get('/') != 2) {
                throw new NoExistentDateFormat(NoExistentDateFormat.NON_EXISTENT_DATE_FORMAT);
            }
        }
        if (format.contains("-")) {
            if (map.get('-') != 2) {
                throw new NoExistentDateFormat(NoExistentDateFormat.NON_EXISTENT_DATE_FORMAT);
            }
        }
        if (map.size() > 8) {
            throw new NoExistentDateFormat(NoExistentDateFormat.NON_EXISTENT_DATE_FORMAT);
        }
        this.format = format;
    }

    public String getFormat() {
            return format;
    }

    public String getFormattedData(){
        System.out.println("Enter the date according to the selected format" + getFormat());
        String resultData;
        if (this.format.contains(" ")) {
            String data = scanner.next();
            String time = scanner.next();
            if (!data.contains("/") || !time.contains(":")) {
                throw new InvalidInput(InvalidInput.DATE_AND_TIME);
            }
            resultData = data + " " + time;
        } else {
            resultData = scanner.next();
            if (!resultData.contains("/")) {
                throw new InvalidInput(InvalidInput.DATE);
            }
        }
        return resultData;
    }
    private void inputDates(String[] dates, String day, String month, String year) {
        if(dates[0].length() == 2) {
            if (day.length() < 2) {
                dates[0] = "0" + day;
            } else {
                dates[0] = day;
            }
        } else if (dates[0].length() == 1) {
            dates[0] = day;
        } else {
            dates[0] = "";
        }

        if(dates[1].length() == 2) {
            if (month.length() < 2) {
                dates[1] = "0" + month;
            } else {
                dates[1] = month;
            }
        } else if (dates[1].length() == 1) {
            dates[1] = month;
        } else if (dates[1].length() == 4) {
            dates[1] = Month.values()[Integer.parseInt(month) - 1].getMonth();
        } else {
            dates[1] = "";
        }

        if(dates[2].length() == 4) {
            if (year.length() < 4) {
                dates[2] = "0" + year;
            } else {
                dates[2] = year;
            }
        } else if (dates[2].length() == 2) {
            dates[2] = year;
        } else {
            dates[2] = "";
        }
    }


    public void inputDateAndTime(String data){

        String[] str = data.split(" ");
        String[] dates = str[0].split("/");
        String[] time = str[1].split(":");
        String day = dates[0];
        String month = dates[1];
        String year = dates[2];
        String seconds = time[0];
        String minutes = time[1];
        String hours = time[2];

        if (this.format.contains(" ")) {
            str = this.format.split(" ");
            if (this.format.contains("/")) {
                dates = str[0].split("/");
            } else {
                dates = str[0].split("-");
            }
            time = str[1].split(":");
            inputDates(dates, day, month, year);
            if (time.length == 3) {
                if (seconds.length() < 2) {
                    time[0] = "0" + seconds;
                } else {
                    time[0] = seconds;
                }
                if (minutes.length() < 2) {
                    time[1] = "0" + minutes;
                } else {
                    time[1] = minutes;
                }
                if (hours.length() < 2) {
                    time[2] = "0" + hours;
                } else {
                    time[2] = hours;
                }
                System.out.println(dates[0] + "/" + dates[1]+ "/" + dates[2] + " " + time[0] + ":" + time[1]+
                        ":" + time[2]);
            } else {
                if (minutes.length() < 2) {
                    time[0] = "0" + minutes;
                } else {
                    time[0] = minutes;
                }
                if (hours.length() < 2) {
                    time[1] = "0" + hours;
                } else {
                    time[1] = hours;
                }
                System.out.println(dates[0] + "/" + dates[1]+ "/" + dates[2] + " " + time[0]+
                        ":" + time[1]);
            }

        } else {
            if (this.format.contains("/")) {
                dates = this.format.split("/");
            } else {
                dates = this.format.split("-");
            }
            inputDates(dates, day, month, year);
            System.out.println(dates[0] + "/" + dates[1]+ "/" + dates[2]);
        }

    }

}
