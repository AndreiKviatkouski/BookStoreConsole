package com.company.console;

import com.company.console.action.*;
import com.company.domain.Role;

import static com.company.console.util.Reader.readInt;
import static com.company.console.util.Writer.writeObject;
import static com.company.console.util.Writer.writeString;

public class ConsoleApplication {

    public static Session session = null;

    private BookAction bookAction = new BookAction();
    private AuthorAction authorAction = new AuthorAction();
    private UserAction userAction = new UserAction();
    private AddressAction addressAction = new AddressAction();
    private StoreAction storeAction = new StoreAction();
    private OrderAction orderAction = new OrderAction();
    private BasketAction basketAction = new BasketAction();


    public void run() {
        while (true) {
            if (session == null) {
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
                    default:
                        writeString("Operation not found");
                }


            } else if (ConsoleApplication.session.getUser().getRole().equals(Role.USER)) {
                showUserMenu();
                switch (readInt()) {
                    case 0:
                        session = null;
                        break;
                    case 1:
                        bookAction.getAll();
                        break;
                    case 2:
                        bookAction.getByTitle();
                        break;
                    case 3:
                        bookAction.getAllByAuthor();
                        break;
                    case 4:
                        bookAction.getById();
                        break;
                    case 5:
                        bookAction.getAllByPrice();
                        break;
                    case 6:
                        showUpdateUserMenu();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                userAction.updateUserByLogin();
                                break;
                            case 2:
                                userAction.updateUserByPassword();
                                break;
                            case 3:
                                userAction.updateUserByName();
                                break;
                            default:
                                writeString("Operation not found");
                                continue;
                        }
                    case 7:
                        basketMenu();
                        switch (readInt()){
                            case 0: continue;
                            case 1: orderAction.add();
                        }
                        break;
                    default:
                        writeString("Operation not found");

                }


            } else if (session.getUser().getRole().equals(Role.ADMIN)) {
                showAdminMenu();
                switch (readInt()) {
                    case 0:
                        session = null;
                        break;
                    case 1:
                        showModifyUserMenu();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                userAction.updateUserByLogin();
                                break;
                            case 2:
                                userAction.updateUserByPassword();
                                break;
                            case 3:
                                userAction.updateUserByName();
                                break;
                            case 4:
                                userAction.getAll();
                                break;
                            case 5:
//                                userAction.getUserByID();
                                break;
                            case 6:
//                                userAction.getUserByLogin();
                                break;
                            case 7:
//                                userAction.removeByID();
                                break;

                            default:
                                writeString("Operation not found");
                                continue;
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
                                authorAction.remove();
                                break;
                            case 4:
                                authorAction.removeById();
                                break;
                            case 5:
                                authorAction.getById();
                                break;
                            case 6:
                                bookAction.getAll();
                                break;

                            default:
                                writeString("Operation not found");
                                continue;
                        }

                    case 3:
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
                            default:
                                writeString("Operation not found");
                                continue;
                        }
                    case 4:
                        showAddressMenu();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                addressAction.add();
                                break;
                            case 2:
                                addressAction.updateHomeById();
                                break;
                            case 3:
                                addressAction.updateStreetById();
                                break;
                            case 4:
                                addressAction.removeByID();
                                break;
                            case 5:
                                addressAction.remove();
                                break;
                            case 6:
                                authorAction.getById();
                                break;
                            case 7:
                                addressAction.getAll();
                                break;
                            case 8:
                                addressAction.getALLByHome();
                                break;
                            case 9:
                                addressAction.getALLByStreet();
                                break;
                            default:
                                writeString("Operation not found");
                                continue;
                        }
                    case 5:
                        showStoreMenu();
                        switch (readInt()) {
                            case 0:
                                continue;
                            case 1:
                                storeAction.save();
                                break;
                            case 2:
                                storeAction.updateTitleById();
                                break;
                            case 3:
                                storeAction.updateAddressById();
                                break;
                            case 4:
                                storeAction.deleteById();
                                break;
                            case 5:
                                storeAction.deleteStore();
                                break;
                            case 6:
                                storeAction.getById();
                                break;
                            case 7:
                                storeAction.getAll();
                                break;
                            case 8:
                                storeAction.getByTitle();
                                break;

                            default:
                                writeString("Operation not found");
                                continue;
                        }
                }
            }
        }
    }

    private void basketMenu() {
        basketAction.findAll();
        writeString("0 - Back");
        writeString("1 - Create order");
    }

    private void showRegMenu() {
        System.err.println("Bookstore Main Menu");
        writeString("0  - Exit");
        writeString("1  - Registration");
        writeString("2  - Authorization");
    }

    private void showUserMenu() {
        writeString("!!!!!USER MENU!!!!!");
        writeString("0  - Logout");
        writeString("1  - Find all books");
        writeString("2  - Find book by title");
        writeString("3  - Find all books by author");
        writeString("4  - Find all books by id");
        writeString("5  - Find all books by price");
        writeString("6  - Show menu update user ");
        writeString("7  - Basket");
    }

    private void showUpdateUserMenu() {
        System.err.println("Update User Menu");
        writeString("0  - Back");
        writeString("1  - Update login by id");
        writeString("2  - Update password by id");
        writeString("3  - Update name by id");
    }

    private void showAdminMenu() {
        writeString("***ADMIN MENU***");
        writeString("0  - Logout");
        writeString("1  - showModifyUserMenu");
        writeString("2  - showAuthorMenu");
        writeString("3  - showBookMenu");
        writeString("4  - showAddressMenu");
        writeString("5  - showStoreMenu");

    }

    private void showModifyUserMenu() {
        writeString("***Modify User Menu***");
        writeString("0  - Back");
        writeString("1  - Update user by Login");
        writeString("2  - Update user by Login");
        writeString("3  - Update user by Login");
        writeString("4  - Get all users");
        writeString("5  - Get user by ID");
        writeString("7 - Get user by login");
        writeString("8  - Remove user by ID");
    }

    private void showAuthorMenu() {
        writeString("***Author Menu***");
        writeString("0  - Back");
        writeString("1  - Create");
        writeString("2  - Update author");
        writeString("3  - Remove by id");
        writeString("4  - Remove");
        writeString("5  - Get by id");
        writeString("6  - Get all");
    }

    private void showBookMenu() {
        writeString("***Book Menu***");
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

    private void showAddressMenu() {
        writeString("***Address Menu***");
        writeString("0  - Back");
        writeString("1  - Create");
        writeString("2  - Update home by id");
        writeString("3  - Update street by id");
        writeString("4  - Remove by id");
        writeString("5  - Remove");
        writeString("6  - Get by id");
        writeString("7  - Get all");
        writeString("8  - Get all by home");
        writeString("9  - Get all by street");
    }

    private void showStoreMenu() {
        writeString("***Store Menu***");
        writeString("0  - Back");
        writeString("1  - Create");
        writeString("2  - Update by title");
        writeString("3  - Update by address");
        writeString("4  - Remove by id");
        writeString("5  - Remove");
        writeString("6  - Get by id");
        writeString("7  - Get all");
        writeString("8  - Get by title");
    }


}
