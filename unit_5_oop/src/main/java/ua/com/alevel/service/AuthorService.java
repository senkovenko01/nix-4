package ua.com.alevel.service;

import ua.com.alevel.entity.Author;

import java.util.List;

public interface AuthorService extends  AbstractDataService<Author> {
    List<Author> findAuthorsByBook(int id);
    Author findAuthorByName(String firstName, String lastName);
}
