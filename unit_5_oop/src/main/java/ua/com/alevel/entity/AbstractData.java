package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class AbstractData {

    private int id;
    private Date created;

    public AbstractData() {
        this.created = new Date();
    }
}
