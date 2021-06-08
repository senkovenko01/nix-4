package ua.com.alevel.dao;

import ua.com.alevel.model.Author;

import java.util.List;

public interface AuthorDAO extends BaseEntityService<Author> {
    Author getByName(String firstName, String lastName);
    List<Author> getByBookName(String name);
    void addBook(String idAuthor, String idBook);
    void deleteBook(String idAuthor, String idBook);
    String printAuthor(Author author);
}
