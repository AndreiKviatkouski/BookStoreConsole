package com.company.console;

import com.company.console.action.AuthorAction;
import com.company.console.action.BookAction;
import com.company.console.action.UserAction;
import com.company.console.util.Writer;
import com.company.domain.Role;

import java.io.IOException;

import static com.company.console.util.Reader.*;
import static com.company.console.util.Writer.*;

public class ConsoleApplication {
    public static Session session = null;

    private BookAction bookAction = new BookAction();
    private AuthorAction authorAction = new AuthorAction();
    private UserAction userAction = new UserAction();



    public void run(){
        while (true){
            if (session == null){
                showRegMenu();
                switch (readInt()){
                    case 0:
                        return;
                    case 1:
                        userAction.reg();
                        break;
                    case 2:
                        userAction.auth();
                        break;
                    default:
                        writeString("Operation not found");
                }
            } else if (session.getUser().getRole().equals(Role.USER)){
                showUserMenu();
                switch (readInt()){

                }
            } else if (session.getUser().getRole().equals(Role.ADMIN)){
                showAdminMenu();
                switch (readInt()){

                }
            }
        }
    }

    private void showAdminMenu() {

    }

    public void runn() {

        while (true) {
            showRegMenu();
            switch (readInt()) {
                case 0:
                    return;
                case 1:
                    userAction.reg();
                    break;
                case 2:
                    userAction.auth();
                    break;
                case 3:
                    userAction.getAll();
                    break;
                case 4:

                    break;
                default:
                    writeString("Invalid operation");
            }

        }
    }

    public void startMenu() {
        while (true) {
            showMainMenu();
            switch (readInt()) {
                case 0:
                    return;
                case 1:
                    showBookMenu();
                    switch (readInt()) {
                        case 1:
                            bookAction.add();
                            break;
                        case 2:
                            bookAction.updateTitleById();
                            break;
                        case 3:
                            bookAction.updateAuthor();
                            break;
                        case 4:
                            bookAction.updatePrice();
                            break;
                        case 5:
                            bookAction.updateDescription();
                            break;
                        case 6:
                            bookAction.removeById();
                            break;
                        case 7:
                            bookAction.remove();
                            break;
                        case 8:
                            bookAction.getById();
                            break;
                        case 9:
                            bookAction.getAll();
                            break;
                        case 10:
                            bookAction.getAllByPrice();
                            break;
                        case 11:
                            bookAction.getAllByAuthor();
                            break;
                        case 12:
                            bookAction.getByTitle();
                            break;
                        default:
                            continue;
                    }
                case 2:
                    showAuthorMenu();
                    switch (readInt()) {
                        case 1:
                            authorAction.add();
                            break;
                        case 2:
                            authorAction.updateAuthor();
                            break;
                        case 3:
                            authorAction.removeById();
                            break;
                        case 4:
                            authorAction.remove();
                            break;
                        case 5:
                            authorAction.getById();
                            break;
                        case 6:
                            authorAction.getAll();
                            break;
                        default:
                            continue;
                    }
                case 3:
                    showUserMenu();
                    break;
                default:
                    //writeString("Operation not found!");
            }
        }
    }

    private void showBookMenu() {
        writeString("0  - Back");
        writeString("1  - Create");
        writeString("2  - Update title by id");
        writeString("3  - Update author");
        writeString("4  - Update price");
        writeString("5  - Update description");
        writeString("6  - Remove by id");
        writeString("7  - Remove");
        writeString("8  - Get by id");
        writeString("9  - Get all");
        writeString("10 - Get all by price");
        writeString("11 - Get all by author");
        writeString("12 - Get all by title");
    }

    private void showAuthorMenu() {
        writeString("0  - Back");
        writeString("1  - Create");
        writeString("2  - Update author");
        writeString("3  - Remove by id");
        writeString("4  - Remove");
        writeString("5  - Get by id");
        writeString("6  - Get all");
    }

    private void showRegMenu() {
        writeString("0  - Exit");
        writeString("1  - Registration");
        writeString("2  - Authorization");
    }

    private void showUserMenu() {
        writeString("0  - Exit");
        writeString("1  - Find all books");
        writeString("2  - Find book by title");
        writeString("3  - Find all books by author");
        writeString("4  - Update login bu id");
        writeString("5  - Update password by id");
        writeString("6  - Update name by id");
    }

    private void showMainMenu() {
        writeString("0 - Back");
        writeString("1 - Book");
        writeString("2 - Author");
    }
}
