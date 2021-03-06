package com.company.console.action;

import com.company.console.ConsoleApplication;
import com.company.console.validator.BookValidator;
import com.company.domain.Author;
import com.company.domain.Book;
import com.company.service.AuthorService;
import com.company.service.AuthorServiceImpl;
import com.company.service.BookService;
import com.company.service.BookServiceImpl;
import com.company.console.exception.BookException;
import com.company.console.exception.UserException;

import java.math.BigDecimal;

import static com.company.console.util.Reader.*;
import static com.company.console.util.Writer.*;

public class BookAction {
    private BookService bookService = new BookServiceImpl();
    private AuthorService authorService = new AuthorServiceImpl();

    public void add() {
        writeString("Enter title");
        String title = readString();
        if (!BookValidator.validTitle(title)) {
            writeString("Invalid title!");
            return;
        }

        writeString("Enter description");
        String desc = readString();
        if (!BookValidator.validDescription(desc)) {
            writeString("Invalid description");
            return;
        }

        writeString("Select author");
        Author[] all = authorService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " Author: " + all[i].getFullName());
        }
        int i = readInt() - 1;
        Author author = all[i];

        writeString("Enter price");
        double price = readDouble();
        if (!BookValidator.validPrice(price)) {
            writeString("Invalid price");
            return;
        }
        Book book = new Book(title, desc, new BigDecimal(price), author);
        bookService.save(book);
    }

    public void updateTitleById() {
        writeString("Enter title");
        String title = readString();
        if (!BookValidator.validTitle(title)) {
            writeString("Invalid title");
            return;
        }
        writeString("Enter id");
        int id = readInt();
        if (!BookValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
        try {
            bookService.updateTitleById(title, id);
        } catch (UserException | BookException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateAuthor() {
        writeString("Select author");
        Author[] all = authorService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " Author: " + all[i].getFullName());
        }
        int i = readInt() - 1;
        Author author = all[i];

        writeString("Enter id");
        int id = readInt();
        if (!BookValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
        try {
            bookService.updateAuthor(author, id);
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updatePrice() {
        writeString("Enter price");
        double price = readDouble();
        if (!BookValidator.validPrice(price)) {
            writeString("Invalid price");
            return;
        }

        writeString("Enter id");
        int id = readInt();
        if (!BookValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
       try {
           bookService.updatePrice(new BigDecimal(price), id);
       }catch (BookException e){
           System.err.println(e.getMessage());
       }
    }

    public void updateDescription() {
        writeString("Enter Description");
        String description = readString();
        if (!BookValidator.validDescription(description)) {
            writeString("Invalid description");
            return;
        }

        writeString("Enter id");
        int id = readInt();
        if (!BookValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
       try {
           bookService.updateDescription(description, id);
       }catch (BookException e){
           System.err.println(e.getMessage());
       }
    }

    public void removeById() {
        writeString("Enter id");
        int id = readInt();
        if (!BookValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
        bookService.remove(id);
    }

    public void remove() {
        Book[] all = bookService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getTitle());
        }
        int i = readInt() - 1;
        Book book = all[i];
        bookService.remove(book);
    }

    public void getById() {
        writeString("Enter id");
        int id = readInt();
        if (!BookValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
        try {
            Book byId = bookService.getById(id);
            writeString(byId.getTitle() + " " + byId.getAuthor());
        }catch (BookException e){
            System.err.println(e.getMessage());
        }
    }
    public void getAll() {
        Book[] all = bookService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getTitle());
        }
        writeString("Choice book");
        int i = readInt() - 1;
        Book book = all[i];
        writeString("Book " + book.getTitle() + " " + book.getAuthor().getFullName() + " " + book.getPrice());
        writeString("0 - Back");
        writeString("1 - Add to basket");
        switch (readInt()){
            case 0: return;
            case 1:
                ConsoleApplication.session.getBasket().add(book);
                break;
            default:
                writeString("Operation not found");
        }
    }

    public void getAllByPrice() {
        writeString("Enter price");
        double price = readDouble();
        if (!BookValidator.validPrice(price)) {
            writeString("Invalid price");
            return;
        }
        Book[] all = bookService.getAllByPrice(new BigDecimal(price));
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getPrice());
        }
    }

    public void getAllByAuthor() {
        writeString("Enter author");
        String author = readString();
        if (!BookValidator.validAuthor(author)) {
            writeString("Invalid author");
            return;
        }
        Book[] all = bookService.getAllByAuthor(author);
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getAuthor());
        }
    }

    public void getByTitle() {
        writeString("Enter title");
        String title = readString();
        if (!BookValidator.validTitle(title)) {
            writeString("Invalid title");
            return;
        }
        try {
            Book all = bookService.getByTitle(title);
            writeString(all.getTitle());
        }catch (BookException e){
            System.err.println(e.getMessage());
        }
    }
}



