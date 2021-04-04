package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class Author extends AbstractData {

    private int id;
    private String firstName;
    private String lastName;

    public Author(){
        super();
    }

}
