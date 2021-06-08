package ua.com.alevel.model;

import ua.com.alevel.exceptions.InvalidInput;

import java.math.BigInteger;

public class Date {
    private String day = "01";
    private String month = "01";
    private String year = "2021";
    private int dataInDayFormat = 737806;
    private Time timeInData = new Time("00","00", "00");
    private BigInteger dataInSeconds = BigInteger.valueOf(0);

    public Date(String data) {
        if (data.contains(" ")) {
            String[] str = data.split(" ");
            String[] arrData = str[0].split("/");
            if(!arrData[0].equals(""))
                this.day = arrData[0];
            if(!arrData[1].equals(""))
                this.month = arrData[1];
            if( arrData.length == 3)
                this.year = arrData[2];
            if (Integer.parseInt(this.day) > 31 || Integer.parseInt(this.day) <= 0) {
                throw new InvalidInput(InvalidInput.DAY_EXCEPTION);
            }
            if (Integer.parseInt(this.month) > 12 || Integer.parseInt(this.month) <= 0) {
                throw new InvalidInput(InvalidInput.MONTH_EXCEPTION);
            }
            if (Integer.parseInt(this.year) < 0) {
                throw new InvalidInput(InvalidInput.YEAR_EXCEPTION);
            }
            this.dataInDayFormat = getDayInMonth() + getDayInYear() + getDays();
            arrData = str[1].split(":");
            if (arrData.length == 3) {
                this.timeInData = new Time(arrData[0], arrData[1], arrData[2]);
            } else {
                this.timeInData = new Time("00", arrData[0], arrData[1]);
            }
            BigInteger daysBig = BigInteger.valueOf(this.dataInDayFormat);
            daysBig = daysBig.multiply(BigInteger.valueOf(86400));
            this.dataInSeconds = daysBig.add(BigInteger.valueOf(this.timeInData.getSeconds()));
        } else {
            String[] arrData = data.split("/");
            if(!arrData[0].equals(""))
                this.day = arrData[0];
            if(!arrData[1].equals(""))
                this.month = arrData[1];
            if( arrData.length == 3)
                this.year = arrData[2];
            if (Integer.parseInt(this.day) > 31 || Integer.parseInt(this.day) <= 0) {
                throw new InvalidInput(InvalidInput.DAY_EXCEPTION);
            }
            if (Integer.parseInt(this.month) > 12 || Integer.parseInt(this.month) <= 0) {
                throw new InvalidInput(InvalidInput.MONTH_EXCEPTION);
            }
            if (Integer.parseInt(this.year) < 0) {
                throw new InvalidInput(InvalidInput.YEAR_EXCEPTION);
            }
            this.dataInDayFormat = getDayInMonth() + getDayInYear() + getDays();
            BigInteger buff = BigInteger.valueOf(this.dataInDayFormat);
            this.dataInSeconds = buff.multiply(BigInteger.valueOf(86400));
        }
    }
    public Time getTime(){
        return this.timeInData;
    }

    @Override
    public String toString() {
        return getFullDataInString();
    }

    public Date() {}

    public Integer getDayInYear(){
        int buff = Integer.parseInt(this.year) - 1;
        int result = 0;
        while (buff > 0) {
            if(buff % 4 == 0 || buff % 100 == 0 || buff % 400 == 0) {
                result += 366;
            } else {
                result += 365;
            }
            buff--;
        }
        return result;
    }
    public Integer getDayInMonth(){
        int buff = Integer.parseInt(this.year);
        int DayBuff = Integer.parseInt(this.month) - 1;
        int result = 0;
        if(buff % 4 == 0 || buff % 100 == 0 || buff % 400 == 0) {
            while (DayBuff > 0) {
                if (DayBuff == 2) {
                    result += Month.values()[DayBuff - 1].getI() + 1;
                } else {
                    result += Month.values()[DayBuff - 1].getI();
                }
                DayBuff--;
            }
        } else {
            while (DayBuff > 0) {
                result += Month.values()[DayBuff - 1].getI();
                DayBuff--;
            }
        }
        return result;
    }

    public Integer getDays(){
        return Integer.parseInt(this.day);
    }

    public static String getDataFromDays(int days){
        String result = "";
        int year = 0;
        while (days > 365) {
            if(year % 4 == 0 || year % 100 == 0 || year % 400 == 0) {
                year++;
                days -= 366;
            } else {
                year++;
                days -= 365;
            }
        }
        int moth = 0;
        for (int i = 0; i < 12; i++) {
            if (days > Month.values()[i].getI()) {
                moth += 1;
                days -= Month.values()[i].getI();
            } else {
                break;
            }
        }
        moth++;
        year++;
        result = days + "/" + moth + "/" + year;
        return result;
    }

    public String getFullDataInString(){
        String result = getDataFromDays(this.dataInDayFormat) + " ";
        result += this.timeInData.getTimeInString();
        return result;
    }

    public String getYear() {
        return year;
    }

    public int getDataInDayFormat() {
        return dataInDayFormat;
    }

    public BigInteger getDataInSeconds() {
        return dataInSeconds;
    }

    public void setDataInDayFormat(int dataInDayFormat) {
        this.dataInDayFormat = dataInDayFormat;
    }
}
