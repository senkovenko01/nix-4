package ua.com.alevel;


public class AppProperties {

    @PropertyKey("user.url")
    public String url;

    @PropertyKey("user.name")
    public String name;

    @PropertyKey("user.pin")
    public int pinCode;

    @PropertyKey("user.status")
    public boolean isActive;

}
