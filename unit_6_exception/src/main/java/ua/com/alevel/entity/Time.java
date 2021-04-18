package ua.com.alevel.entity;

import ua.com.alevel.exceptions.InvalidInput;

public class Time {
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;

    public Time(String seconds, String minutes, String hours) {
        this.hours = Integer.parseInt(hours);
        this.minutes = Integer.parseInt(minutes);
        this.seconds = Integer.parseInt(seconds);
        if (this.hours >= 24 || this.hours < 0) {
            throw new InvalidInput(InvalidInput.HOURS_EXCEPTION);
        }
        if (this.minutes >= 60 || this.minutes < 0) {
            throw new InvalidInput(InvalidInput.MINUTES_EXCEPTION);
        }
        if (this.seconds >= 60 || this.seconds < 0) {
            throw new InvalidInput(InvalidInput.SECONDS_EXCEPTION);
        }
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.hours * 60 + this.minutes;
    }

    public int getSeconds() {
        return this.hours * 60 * 60 + this.minutes * 60 + this.seconds;
    }

    public long getMilliseconds() {
        return (this.hours * 60 * 60 + this.minutes * 60 + this.seconds) * 1000;
    }

    public int setTimeFromSeconds(int seconds) {
        int hours = seconds / 3600;
        int days = 0;
        while (hours >= 24) {
            days++;
            hours -= 24;
        }
        int second = seconds % 3600;
        int minutes = 0;
        while (second >= 60) {
            minutes++;
            second -= 60;
        }
        this.seconds = second;
        this.hours = hours;
        this.minutes = minutes;
        return days;
    }

    public String getTimeInString() {
        return this.seconds + ":" + this.minutes + ":" + this.hours;
    }
}
