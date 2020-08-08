package com.company.console.action;

import com.company.console.validator.AuthorValidator;
import com.company.console.validator.BookValidator;
import com.company.domain.Author;
import com.company.service.AuthorService;
import com.company.service.AuthorServiceImpl;

import static com.company.console.util.Reader.*;
import static com.company.console.util.Reader.readString;
import static com.company.console.util.Writer.writeString;

public class AuthorAction {
    private AuthorService authorService = new AuthorServiceImpl();
    //private Author author = new Author();

    public void add() {
        writeString("Enter Name");
        String fullName = readString();
        if (!AuthorValidator.validFullName(fullName)) {
            writeString("Invalid Name!");
            return;
        }
        Author authorNew = new Author(fullName);
        authorService.save(authorNew);
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
        authorService.updateAuthor(author, id);
    }

    public void removeById() {
        writeString("Enter id");
        int id = readInt();
        if (!AuthorValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
        authorService.remove(id);
    }

    public void remove() {
        Author[] all = authorService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getFullName());
        }
        int i = readInt() - 1;
        Author author = all[i];
        authorService.remove(author);
    }

    public void getById() {
        writeString("Enter id");
        int id = readInt();
        if (!AuthorValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
        Author byId = authorService.getById(id);
        writeString(byId.getFullName());
    }

    public void getAll() {
        Author[] all = authorService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getFullName());
        }
    }
}