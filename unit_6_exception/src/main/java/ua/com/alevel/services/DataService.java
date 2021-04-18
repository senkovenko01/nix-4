package ua.com.alevel.services;

import ua.com.alevel.entity.Date;
import ua.com.alevel.utils.DateUtils;

import java.util.List;

public class DataService {

    public Date date = new Date();

    public void difference(String firstDate, String secondDate) {
        DateUtils.subtractData(new Date(firstDate), new Date(secondDate));
    }

    public void plusDate(String firstDate, int type, int count, InputService inputService) {
        switch (type) {
            case (0):
                date = DateUtils.addSecondsToData(new Date(firstDate), count);
                break;
            case (1):
                date = DateUtils.addSecondsToData(new Date(firstDate), count * 60);
                break;
            case (2):
                date = DateUtils.addSecondsToData(new Date(firstDate), count * 3600);
                break;
            case (3):
                date = DateUtils.addTimeToData(new Date(firstDate), count);
                break;
            case (4):
                date = DateUtils.addTimeToData(new Date(firstDate), count * 30);
                break;
            case (5):
                date = DateUtils.addTimeToData(new Date(firstDate), count * 365);
                break;
        }
        inputService.inputDateAndTime(date.getFullDataInString());
    }

    public void subtractDate(String d1, int type, int count, InputService inputService) {
        switch (type) {
            case (0):
                date = DateUtils.subtractSecondsToData(new Date(d1), count);
                break;
            case (1):
                date = DateUtils.subtractSecondsToData(new Date(d1), count * 60);
                break;
            case (2):
                date = DateUtils.subtractSecondsToData(new Date(d1), count * 3600);
                break;
            case (3):
                date = DateUtils.takeAwayTimeInData(new Date(d1), count);
                break;
            case (4):
                date = DateUtils.takeAwayTimeInData(new Date(d1), count * 30);
                break;
            case (5):
                date = DateUtils.takeAwayTimeInData(new Date(d1), count * 365);
                break;
        }
        inputService.inputDateAndTime(date.getFullDataInString());
    }

    public void sortByAsc(String[] arr, InputService inputService) {
        Date[] data = new Date[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = new Date(arr[i]);
        }
        List<Date> list = DateUtils.compareData(data);
        for (Date x : list) {
            inputService.inputDateAndTime(x.getFullDataInString());
        }
    }

    public void sortByDesc(String[] arr, InputService inputService) {
        Date[] data = new Date[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = new Date(arr[i]);
        }
        List<Date> list = DateUtils.compareDataRevers(data);
        for (Date d : list) {
            inputService.inputDateAndTime(d.getFullDataInString());
        }
    }
}
