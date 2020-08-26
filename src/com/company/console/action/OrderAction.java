package com.company.console.action;

import com.company.console.ConsoleApplication;
import com.company.console.exception.BookException;
import com.company.console.exception.OrderException;
import com.company.console.validator.AddressValidator;
import com.company.console.validator.BookValidator;
import com.company.domain.*;
import com.company.service.*;

import java.math.BigDecimal;
import java.util.Arrays;

import static com.company.console.util.Reader.readInt;
import static com.company.console.util.Reader.readString;
import static com.company.console.util.Writer.writeObject;
import static com.company.console.util.Writer.writeString;

public class OrderAction {
    private OrderService orderService = new OrderServiceImpl();
    private BookService bookService = new BookServiceImpl();


    //    private User user;
//    private Address address;
//    private Store store;
//
//    private Status status = Status.ACTIVE;
//    private Type type;
//
//    private Book[] books;
//    private BigDecimal totalPrice;

    public void add() {
        writeString("Choice delivery type: 1 -delivery; 2 - pickup; 0 - return");
        while (true) {
            switch (readInt()) {
                case 0:
                    return;
                case 1:
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
                    User user = ConsoleApplication.session.getUser();
                    Book[] all = ConsoleApplication.session.getBasket().getAll();
                    BigDecimal totalPrice = getTotalPrice(all);
                    Order order = new Order(user, address, all, totalPrice);
                    orderService.save(order);
                    break;
                case 2:









                    break;
                default:
                    writeString("Operation not found");
            }
        }

    }

    private BigDecimal getTotalPrice(Book[] all) {
        double total = 0;
        for (Book book : all) {
            double v = book.getPrice().doubleValue();
            total = v + total;
        }
        return new BigDecimal(total);
    }


    public void removeById() {
        writeString("Enter id");
        int id = readInt();
        try {
            orderService.remove(id);
        } catch (OrderException e) {
            e.printStackTrace();
        }
    }

    public void removeByOrder() {
    }

    public void updateOrderById() {

    }

    // TODO: 26.08.2020 Реализовать все методы OrderAction
    // TODO: 26.08.2020 Реализовать вывод информации по всем заказам

    public void addBook() {
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


    public void removeBook() {
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
        Order[] orders = orderService.getAll();
        for (int i = 0; i < orders.length; i++) {
            writeObject(i + 1 + ": " + orders[i]);
        }

    }

    void getAllByUser() {

    }

    void getAllByStore() {

    }
}
