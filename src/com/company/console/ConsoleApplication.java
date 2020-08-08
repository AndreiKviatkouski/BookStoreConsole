package com.company.console;

import com.company.console.action.AuthorAction;
import com.company.console.action.BookAction;

import static com.company.console.util.Reader.*;
import static com.company.console.util.Writer.*;

public class ConsoleApplication {
    private BookAction bookAction = new BookAction();
    private AuthorAction authorAction = new AuthorAction();

    public void run() {
        while (true) {
            showMainMenu();
            switch (readInt()) {
                case 0:
                    return;
                case 1:
                    showBookMenu();
                    switch (readInt()) {
                        case 0:
                            continue;
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
                    }
                case 2:
                    showAuthorMenu();
                    switch (readInt()) {
                        case 0:
                            continue;
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
                    }
                default:
                    writeString("Operation not found!");
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

    private void showMainMenu() {
        writeString("0 - Exit");
        writeString("1 - Book");
        writeString("2 - Author");
    }
}
