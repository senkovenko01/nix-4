package ua.com.alevel.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Book extends AbstractData {

    private int id;
    private String name;
    private List<Integer> authorId;
    private Set<String> authors = new HashSet<>();

    public Book() {
        super();
    }
    public void setAuthor(String str) {
        authors.add(str);
    }

}
