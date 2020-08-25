package com.company.console.action;

import com.company.console.ConsoleApplication;
import com.company.console.exception.BookException;
import com.company.console.validator.AddressValidator;
import com.company.console.validator.BookValidator;
import com.company.domain.*;
import com.company.service.*;

import static com.company.console.util.Reader.readInt;
import static com.company.console.util.Reader.readString;
import static com.company.console.util.Writer.writeObject;
import static com.company.console.util.Writer.writeString;

public class OrderAction {
    OrderService orderService = new OrderServiceImpl();
    BookService bookService = new BookServiceImpl();
    AddressService addressService = new AddressServiceImpl();

    //    private User user;
//    private Address address;
//    private Store store;
//
//    private Status status = Status.ACTIVE;
//    private Type type;
//
//    private Book[] books;
//    private BigDecimal totalPrice;
    public static void main(String[] args) {
        OrderAction orderAction = new OrderAction();
        orderAction.addBook();
    }

    void add() {
        Order order = new Order();
        User user = ConsoleApplication.session.getUser();
        //set user in order
        order.setUser(user);
        writeString("Choice delivery type");
        while (true) {
            switch (readInt()) {
                case 0:
                    return;
                case 1:
                    //set type in order
                    order.setType(Type.DELIVERY);

                    //read and set address
                    writeString("Enter your address");
                    writeString("Enter street");
                    String street = readString();
                    if (!AddressValidator.validStreet(street)) {
                        writeString("Invalid street: " + street);
                        return;
                    }
                    writeString("Enter home number");
                    int home = readInt();
                    if (!AddressValidator.validHome(home)) {
                        writeString("Invalid home number: " + home);
                        return;
                    }
                    Address address = new Address(street, home);
                    order.setAddress(address);

                    //read and set book[]
                    writeString("Choice book by id");

                    Book[] bookAll = bookService.getAll();
                    for (int i = 0; i < bookAll.length; i++) {
                        writeObject(i + 1 + ": " + bookAll[i]);
                    }

                    int id = readInt();
                    if (!BookValidator.validId(id) || id > bookAll.length) {
                        writeString("Invalid id");
                        return;
                    }
                    try {
                        Book book = bookService.getById(id);
                        writeString("Book was added: " + book);
                    } catch (BookException e) {
                        System.err.println(e.getMessage());
                    }
                      Book[]books = new Book[5];
                    orderService.save(order);
                    writeString("Order was add: " + order);
                    break;
                case 2:
                    order.setType(Type.PICKUP);
                    break;
                default:
                    writeString("Operation not found");
            }
        }

    }


    void removeById() {
    }

    void removeByOrder() {
    }

    void updateOrderById() {

    }

    void addBook() {
        writeString("Choice book by id");

        Book[] bookAll = bookService.getAll();
        for (int i = 0; i < bookAll.length; i++) {
            writeObject(i + 1 + ": " + bookAll[i]);
        }

        int id = readInt();
        if (!BookValidator.validId(id) || id > bookAll.length) {
            writeString("Invalid id");
            return;
        }
        try {
            Book book = bookService.getById(id);
            writeString("Book was added: " + book);
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }
    }


    void removeBook() {
        Book[] all = bookService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getTitle());
        }
        int i = readInt() - 1;
        Book book = all[i];
        bookService.remove(book);

    }

    void getById() {

    }

    void getAll() {
        Book[] bookAll = bookService.getAll();
        for (int i = 0; i < bookAll.length; i++) {
            writeObject(i + 1 + ": " + bookAll[i]);
        }

    }

    void getAllByUser() {

    }

    void getAllByStore() {

    }
}
