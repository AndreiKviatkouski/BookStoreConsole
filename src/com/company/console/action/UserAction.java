package com.company.console.action;

import com.company.console.Basket;
import com.company.console.ConsoleApplication;
import com.company.console.util.Reader;
import com.company.console.util.Writer;

import com.company.console.validator.UserValidator;

import com.company.console.Session;
import com.company.domain.User;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;
import com.company.console.exception.UserException;


import static com.company.console.util.Reader.*;
import static com.company.console.util.Writer.*;
import static com.company.domain.Role.USER;

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
        if (byLogin == null) {
            writeString("User not found");
            return;
        }
        User userByPassword = userService.checkUser(login, password);
        if (userByPassword != null) {
            writeString("Hello " + userByPassword.getName() + "! , " + "Authorization is successful");
            ConsoleApplication.session = new Session(userByPassword, new Basket());
        } else {
            writeString("Wrong password!");
        }

    }


    public void reg() {
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
        writeString("Enter name");
        String name = readString();
        if (!UserValidator.validName(name)) {
            writeString("Invalid name");
            return;
        }
        User user = new User(login, password, name);
        user.setRole(USER);
        userService.save(user);
        writeString("Registration is successful");
        System.out.println(user);//////////////////////////////////

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
        try {
            userService.updateUserByLogin(login, id);
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
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
        try {
            userService.updateUserByPassword(password, id);
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }

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
        try {
            userService.updateUserByName(name, id);
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }

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