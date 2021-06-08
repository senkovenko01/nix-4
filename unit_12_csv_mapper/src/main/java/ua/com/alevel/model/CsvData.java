package ua.com.alevel.model;

import java.util.ArrayList;
import java.util.List;

public class CsvData {

    private final List<String[]> users;

    public CsvData() {
        this.users = new ArrayList<>();
    }

    public CsvData(List<String[]> users) {
        this.users = users;
    }

    public int size() {
        return this.users.size() - 1;
    }

    public String getUsersByRowAndColumn(int row, int column) {
        return this.users.get(row + 1)[column];
    }

    public String getUsersByRowNumberAndNameOfColumn(int row, String name) {
        int column = List.of(users.get(0)).indexOf(name);
        if (column == -1) {
            throw new RuntimeException("Non existent column!");
        }
        return this.users.get(row+1)[column];
    }

    public String[] getHead() {

        return this.users.get(0);
    }

    public void add(String[] row) {
        this.users.add(row);
    }

    @Override
    public String toString() {
        return "CsvData{" +
                "users=" + users +
                '}';
    }
}
