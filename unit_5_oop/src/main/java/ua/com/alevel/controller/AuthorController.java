package ua.com.alevel.controller;

import lombok.SneakyThrows;
import ua.com.alevel.entity.Author;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.impl.AuthorServiceImpl;

import java.util.Scanner;

public class AuthorController {

    private final AuthorService authorService = new AuthorServiceImpl();

    @SneakyThrows
    public void create(Scanner scanner) {

        System.out.println("Write first and last name of author through space");
        String name = scanner.nextLine();
        String[] firstLastName = name.split(" ");

        Author author = new Author();
        author.setFirstName(firstLastName[0]);
        author.setLastName(firstLastName[1]);
        authorService.create(author);

    }

    @SneakyThrows
    public void update(Scanner scanner) {
        System.out.println("Write author id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Write author first name ");
        String firstName = scanner.nextLine();
        System.out.println("Write author last name");
        String lastName = scanner.nextLine();

        Author author = authorService.read(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorService.update(author);
    }

    @SneakyThrows
    public void delete(Scanner scanner) {
        System.out.println("Write author id");
        int id = Integer.parseInt(scanner.nextLine());
        authorService.delete(id);
    }


    public void readAllAuthors() {
        System.out.println("authors = " + authorService.read());
    }

    @SneakyThrows
    public void readAuthorById(Scanner scanner) {
        System.out.println("Write author id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("author = " + authorService.read(id));
    }


    @SneakyThrows
    public void readAuthorByBook(Scanner scanner) {
        System.out.println("please enter book id ...");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("authors who wrote the book " + authorService.findAuthorsByBook(id));
    }

    public void run() {
        System.out.println("Author controller");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select operation :" +
                "\n1 - create author" +
                "\n2 - update author" +
                "\n3 - read all authors" +
                "\n4 - read author by id" +
                "\n5 - read author by book" +
                "\n6 - delete author");
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
                    readAllAuthors();
                    break;
                case "4":
                    readAuthorById(scanner);
                    break;
                case "5":
                    readAuthorByBook(scanner);
                    break;
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
