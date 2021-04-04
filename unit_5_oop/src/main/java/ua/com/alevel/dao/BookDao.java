package ua.com.alevel.dao;

import ua.com.alevel.entity.Book;


import java.util.List;

public interface BookDao extends AbstractDataDao<Book> {

    List<Book> readBooksByAuthor(int id);
    Book findBookByName(String name);

}
