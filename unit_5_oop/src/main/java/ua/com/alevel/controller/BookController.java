package ua.com.alevel.controller;

import lombok.SneakyThrows;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.BookService;
import ua.com.alevel.service.impl.AuthorServiceImpl;
import ua.com.alevel.service.impl.BookServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookController {
    private final AuthorService authorService = new AuthorServiceImpl();
    private final BookService bookService = new BookServiceImpl();

    @SneakyThrows
    public void create(Scanner scanner) {

        List<Integer> authorId = new ArrayList<>();

        System.out.println("Write name of book");
        String name = scanner.nextLine();
        System.out.println("How many authors does the book have?");
        int numberOfAuthors = Integer.parseInt(scanner.nextLine());
        List<String> namesOfAuthors = new ArrayList<>();

        for (int i = 0; i < numberOfAuthors; i++) {
            System.out.println("Write name of next author through space");
            namesOfAuthors.add(scanner.nextLine());
        }

        for (String s : namesOfAuthors) {
            Author author = new Author();
            String[] fistLastName = s.split(" ");
            author.setFirstName(fistLastName[0]);
            author.setLastName(fistLastName[1]);
            Author authorInDB = authorService.findAuthorByName(author.getFirstName(), author.getLastName());

            if (authorInDB == null) {
                authorService.create(author);
                authorId.add(authorService.findAuthorByName(author.getFirstName(), author.getLastName()).getId());
            } else authorId.add(authorInDB.getId());
        }

        Book book = new Book();
        book.setName(name);
        book.setAuthorId(authorId);
        bookService.create(book);

    }


    @SneakyThrows
    public void update(Scanner scanner) {
        System.out.println("Choose book id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Write a new name for the book ");
        String name = scanner.nextLine();

        Book book = bookService.read(id);
        book.setName(name);
        bookService.update(book);
    }

    @SneakyThrows
    public void delete(Scanner scanner) {
        System.out.println("please enter book id ...");
        int id = Integer.parseInt(scanner.nextLine());
        bookService.delete(id);

    }

    public void readAllBooks() {
        System.out.println("books = " + bookService.read());
    }

    @SneakyThrows
    public void readBookById(Scanner scanner) {
        System.out.println("Write book id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("book = " + bookService.read(id));
    }


    @SneakyThrows
    public void readBooksByAuthor(Scanner scanner) {
        System.out.println("please enter author id ...");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Books written by author " + bookService.findBooksByAuthor(id));

    }

    public void run() {
        System.out.println("Book controller");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select operation :" +
                "\n1 - create book" +
                "\n2 - update book" +
                "\n3 - read all books" +
                "\n4 - read book by id" +
                "\n5 - read book by author" +
                "\n6 - delete book");
        String check;
        while ((check = scanner.nextLine()) != null) {

            switch (check) {
                case "0":
                    return;
                case "1":
                    create(scanner);
                    break;
                case "2":
                    update(scanner);
                    break;
                case "3":
                    readAllBooks();
                    break;
                case "4":
                    readBookById(scanner);
                    break;
                case "5":
                    readBooksByAuthor(scanner);
                case "6":
                    delete(scanner);
                    break;
                default:
                    System.out.println("Invalid number of operation");

            }
            System.out.println("If you want to back to the main panel, please input 0, else repeat logic");
        }
    }
}
