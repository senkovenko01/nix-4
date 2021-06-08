package ua.com.alevel.model;

import ua.com.alevel.annotation.UserCsv;

public class User {

    @UserCsv("id")
    private String id;

    @UserCsv("name")
    private String name;

    @UserCsv("password")
    private String password;

    @Override
    public String toString() {
        return "id = " + id  +
                ", name = " + name  +
                ", password = " + password;
    }
}
