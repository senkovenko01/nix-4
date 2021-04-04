package ua.com.alevel.service;

import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

import java.util.List;

public interface BookService extends AbstractDataService<Book> {
    List<Book> findBooksByAuthor(int id);
    Book findBookByName(String name);

}
