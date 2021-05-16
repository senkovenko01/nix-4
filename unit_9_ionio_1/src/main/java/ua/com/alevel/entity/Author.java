package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Author extends BaseEntity{

    private String firstName;
    private String lastName;
    private List<String> bookList;

    public void setBookList(List<String> list){
        this.bookList = list;
    }

    public Author(){
        super();
        this.bookList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
