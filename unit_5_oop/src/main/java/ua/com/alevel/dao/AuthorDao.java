package ua.com.alevel.dao;

import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

import java.util.List;

public interface AuthorDao extends AbstractDataDao<Author> {

    List<Author> readAuthorsByBook(int id);
    Author findAuthorByName(String firstName, String lastName);

}
