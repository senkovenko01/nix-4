package ua.com.alevel.entity;

import lombok.Getter;

@Getter
public enum Month {
    JANUARY(31, "January "), FEBRUARY(28, "February"), MARCH(31, "March"),
    APRIL(30, "April"), MAY(31, "May"), JUNE(30, "June"),
    JULY(31, "July"), AUGUST(31, "August"), SEPTEMBER(30, "September"),
    OCTOBER(31, "October"), NOVEMBER(30, "November"), DECEMBER(31, "December");

    String month;
    int i;

    Month(int i, String month) {
        this.i = i;
        this.month = month;
    }
}
