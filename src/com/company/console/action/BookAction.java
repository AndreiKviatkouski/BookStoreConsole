package com.company.console.action;

import com.company.console.validator.BookValidator;
import com.company.domain.Book;
import com.company.service.BookService;
import com.company.service.BookServiceImpl;

import static com.company.console.util.Reader.*;
import static com.company.console.util.Writer.*;

public class BookAction {
    private BookService bookService = new BookServiceImpl();

    public void add() {
        writeString("Enter title");
        String title = readString();
        if (!BookValidator.validTitle(title)){
            writeString("Invalid title!");
            return;
        }

        writeString("Enter description");
        String desc = readString();
        if (!BookValidator.validDescription(desc)){
            writeString("Invalid description");
            return;
        }

        writeString("Enter author");
        String author = readString();
        if (!BookValidator.validAuthor(desc)){
            writeString("Invalid author");
            return;
        }
        writeString("Enter price");
        double price = readDouble();
        if (!BookValidator.validPrice(price)){
            writeString("Invalid price");
            return;
        }
        Book book = new Book(title, desc, price, author);
        bookService.save(book);
    }

    public void updateTitleById() {
        writeString("Enter title");
        String title = readString();
        if (!BookValidator.validTitle(title)){
            writeString("Invalid title");
            return;
        }
        writeString("Enter id");
        int id = readInt();
        if (!BookValidator.validId(id)){
            writeString("Invalid id");
            return;
        }
        bookService.updateTitleById(title, id);
    }

    public void updateAuthor() {
        writeString("Enter author");
        String author = readString();
        if (!BookValidator.validAuthor(author)){
            writeString("Invalid author");
            return;
        }

        writeString("Enter id");
        int id = readInt();
        if (!BookValidator.validId(id)){
            writeString("Invalid id");
            return;
        }
        bookService.updateAuthor(author, id);
    }

    public void updatePrice() {
        writeString("Enter price");
        double price = readDouble();
        if (!BookValidator.validPrice(price)){
            writeString("Invalid price");
            return;
        }

        writeString("Enter id");
        int id = readInt();
        if (!BookValidator.validId(id)){
            writeString("Invalid id");
            return;
        }
        bookService.updatePrice(price, id);
    }

    public void updateDescription() {
        writeString("Enter Description");
        String description = readString();
        if (!BookValidator.validDescription(description)){
            writeString("Invalid description");
            return;
        }

        writeString("Enter id");
        int id = readInt();
        if (!BookValidator.validId(id)){
            writeString("Invalid id");
            return;
        }
        bookService.updateDescription(description, id);
    }

    public void removeById() {
        writeString("Enter id");
        int id = readInt();
        if (!BookValidator.validId(id)){
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
        if (!BookValidator.validId(id)){
            writeString("Invalid id");
            return;
        }
        Book byId = bookService.getById(id);
        writeString(byId.getTitle() + " " + byId.getAuthor());
    }

    public void getAll() {
        Book[] all = bookService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getTitle());
        }
    }

    public void getAllByPrice() {
        writeString("Enter price");
        double price = readDouble();
        if (!BookValidator.validPrice(price)){
            writeString("Invalid price");
            return;
        }
        Book[] all = bookService.getAllByPrice(price);
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getPrice());
        }
    }

    public void getAllByAuthor() {
        writeString("Enter author");
        String author = readString();
        if (!BookValidator.validAuthor(author)){
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
        if (!BookValidator.validTitle(title)){
            writeString("Invalid title");
            return;
        }
        Book all = bookService.getByTitle(title);
        writeString(all.getTitle());
    }
}



