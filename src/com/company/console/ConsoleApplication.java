package com.company.console;

import com.company.console.action.BookAction;

import static com.company.console.util.Reader.*;
import static com.company.console.util.Writer.*;

public class ConsoleApplication {
    private BookAction bookAction = new BookAction();

    public void run() {
        while (true){
            showMainMenu();
            switch (readInt()){
                case 0:
                    return;
                case 1:
                    showBookMenu();
                    switch (readInt()){
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
                        case 10 :
                            bookAction.getAllByPrice();
                            break;
                        case 11 :
                            bookAction.getAllByAuthor();
                            break;
                        case 12:
                            bookAction.getByTitle();
                            break;
                        default:
                            writeString("Operation not found!");
                    }
            }
        }
    }

    private void showBookMenu() {
        writeString("0 - Back");
        writeString("1 - Create");
        writeString("2 - Update title by id");
        writeString("3 - Update author");
        writeString("4 - Update price");
        writeString("5 - Update description");
        writeString("6 - remove by id");
        writeString("7 - remove");
        writeString("8 - get by id");
        writeString("9 - get all");
        writeString("10 - get all by price");
        writeString("11 - get all by author");
        writeString("12 - get all by title");
    }

    private void showMainMenu(){
        writeString("0 - Exit");
        writeString("1 - Book");
    }
}
