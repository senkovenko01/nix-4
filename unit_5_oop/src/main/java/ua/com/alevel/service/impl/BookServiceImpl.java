package ua.com.alevel.service.impl;

import org.apache.log4j.Logger;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.dao.impl.AuthorDaoImpl;
import ua.com.alevel.dao.impl.BookDaoImpl;
import ua.com.alevel.entity.Book;
import ua.com.alevel.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookDao bookDao = new BookDaoImpl();
    private final AuthorDao authorDao = new AuthorDaoImpl();

    private final Logger log = Logger.getLogger(BookServiceImpl.class);

    @Override
    public void create(Book data) {
        log.info("Creating book");
        Book book = bookDao.findBookByName(data.getName());

        if (book != null && book.getAuthorId().containsAll(data.getAuthorId())) {
            log.info("Book already exist " + book);
            throw new RuntimeException("Book already exist " + book);
        }
        bookDao.create(data);
        log.info("Book was created " + data);

    }

    @Override
    public Book read(int id) {
        log.info("Reading book, id=" + id);
        if (!exist(id)) {
            log.error("Book doesn't exist ");
            throw new RuntimeException("Book doesn't exist");
        }
        log.info("Read book from InMemoryDB, id=" + bookDao.read(id));
        return bookDao.read(id);
    }


    @Override
    public List<Book> read() {
        log.info("Read all books from InMemoryDB");
        return bookDao.read();
    }

    @Override
    public void update(Book data) {

        log.info("Updating book, id=" + data.getId());
        if (!exist(data.getId())) {
            log.error("Book doesn't exist, id=" + data.getId());
            throw new RuntimeException("Book doesn't exist");
        }
        bookDao.update(data);
        log.info("Book was updated " + bookDao.read(data.getId()));
    }


    @Override
    public void delete(int id) {
        log.info("Deleting a book, id=" + id);
        if (!exist(id)) {
            log.error("Book doesn't exist, id=" + id);
            throw new RuntimeException("book doesn't exist");
        }
        bookDao.delete(id);
        log.info("Book was deleted, id=" + id);

    }

    @Override
    public boolean exist(int id) {
        log.info("Is exist?, id=" + id);
        return bookDao.exist(id);
    }

    @Override
    public List<Book> findBooksByAuthor(int id) {

        log.info("Read books by author, author id=" + id);
        if (!authorDao.exist(id)) {
            log.error("Author doesn't exist, id=" + id);
            throw new RuntimeException("Author doesn't exist, id=" + id);
        }
        return bookDao.readBooksByAuthor(id);
    }

    @Override
    public Book findBookByName(String name) {
        log.info("Find book by name: " + name);
        return bookDao.findBookByName(name);
    }
}
