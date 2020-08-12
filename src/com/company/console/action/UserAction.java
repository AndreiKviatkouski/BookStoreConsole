package com.company.console.action;

import com.company.console.ConsoleApplication;
import com.company.console.util.Reader;
import com.company.console.util.Writer;
import com.company.console.validator.BookValidator;
import com.company.console.validator.UserValidator;
import com.company.domain.Author;
import com.company.domain.User;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;
import com.company.storage.UserStorage;
import com.company.storage.UserStorageImpl;

import static com.company.console.util.Reader.*;
import static com.company.console.util.Writer.*;

public class UserAction {
    private UserService userService = new UserServiceImpl();

    public void auth() {
        writeString("Enter login");
        String login = readString();
        if (!UserValidator.validLogin(login)) {
            writeString("Invalid login");
            return;
        }
        writeString("Enter password");
        String password = readString();
        if (!UserValidator.validPassword(password)) {
            writeString("Invalid password");
            return;
        }
        User byLogin = userService.getByLogin(login);
        if (byLogin == null){
            writeString("User not found");
            return;
        }
        if (byLogin.getPassword().equals(password)) {
            ConsoleApplication.session.setUser(byLogin);
            writeString("Hello " + byLogin.getName() + "! , " + "Authorization is successful");
        } else {
            writeString("Wrong password!");
        }

    }


    public boolean reg() {
        writeString("Enter login");
        String login = readString();
        if (!UserValidator.validLogin(login)) {
            writeString("Invalid login");
            return false;
        }
        writeString("Enter password");
        String password = readString();
        if (!UserValidator.validPassword(password)) {
            writeString("Invalid password");
            return false;
        }
        writeString("Enter name");
        String name = readString();
        if (!UserValidator.validName(name)) {
            writeString("Invalid name");
            return false;
        }
        User user = new User(login, password, name);
        userService.save(user);
        writeString("User is already exist");
        return false;
    }

    public void getAll() {
        User[] all = userService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getLogin() + " " + all[i].getName());
        }
    }

    public void updateUserByLogin() {
        Writer.writeString("Enter Id");
        int id = Reader.readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
        Writer.writeString("Enter new login");
        String login = Reader.readString();
        if (!UserValidator.validLogin(login)) {
            writeString("Invalid login");
        }
        userService.updateUserByLogin(login, id);
    }

    public void updateUserByPassword() {
        Writer.writeString("Enter Id");
        int id = Reader.readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
        Writer.writeString("Enter new password");
        String password = Reader.readString();
        if (!UserValidator.validPassword(password)) {
            writeString("Invalid password");
        }
        userService.updateUserByPassword(password, id);

    }

    public void updateUserByName() {
        Writer.writeString("Enter Id");
        int id = Reader.readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
        Writer.writeString("Enter new Name");
        String name = Reader.readString();
        if (!UserValidator.validName(name)) {
            writeString("Invalid name");
        }
        userService.updateUserByName(name, id);

    }

//    public void updateUser() {
//        writeString("Select user");
//        Author[] all = authorService.getAll();
//        for (int i = 0; i < all.length; i++) {
//            writeString((i + 1) + " Author: " + all[i].getFullName());
//        }
//        int i = readInt() - 1;
//        Author author = all[i];
//
//        writeString("Enter id");
//        int id = readInt();
//        if (!BookValidator.validId(id)){
//            writeString("Invalid id");
//            return;
//        }
//        bookService.updateAuthor(author, id);
//    }

}