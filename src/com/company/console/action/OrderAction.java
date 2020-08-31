package com.company.console.action;

import com.company.console.ConsoleApplication;
import com.company.console.exception.BookException;
import com.company.console.exception.OrderException;
import com.company.console.exception.StorageException;
import com.company.console.validator.AddressValidator;
import com.company.console.validator.BookValidator;
import com.company.domain.*;
import com.company.service.*;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

import static com.company.console.util.Reader.readInt;
import static com.company.console.util.Reader.readString;
import static com.company.console.util.Writer.writeObject;
import static com.company.console.util.Writer.writeString;

public class OrderAction {
    private OrderService orderService = new OrderServiceImpl();
    private BookService bookService = new BookServiceImpl();
    private StoreService storeService = new StoreServiceImpl();

//    public static void main(String[] args) {
//        OrderAction orderAction = new OrderAction();
//        orderAction.add();
//    }

    public void add() {
        writeString("Choice delivery type: 1 -delivery; 2 - pickup; 3 - show all user's orders; 0 - return");
        while (true) {
            switch (readInt()) {
                case 0:
                    return;
                case 1:
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

                   Book[]books = bookService.getAll();
                    for (int i = 0; i < books.length; i++) {
                        writeString(i+1 + " " + books[i].getTitle());
                    }
                    writeString("Enter number book");
                    int id = readInt();
                    if (!BookValidator.validId(id)) {
                        writeString("Invalid book number");
                        return;
                    }

                    Book book = null;
                    try {
                        book = bookService.getById(id);
                    } catch (BookException e) {
                        e.printStackTrace();
                    }

                    ConsoleApplication.session.getBasket().add(book);

                    Book[] all = ConsoleApplication.session.getBasket().getAll();
                    BigDecimal totalPrice = getTotalPrice(all);
                    System.out.println(totalPrice);
                    Order order = new Order(user, address, all, totalPrice);
                    orderService.save(order);
                    System.out.println(order);
                    break;
                case 2:

//                    writeString("Choice store number");
//                    Store[] stores = storeService.getAll();
//                    for (int i = 0; i < stores.length; i++) {
//                        writeObject(i + 1 + ":" + stores[i].getTitle() + " " + stores[i].getAddress());
//                    }
//                    int id2= readInt();
//                    Store store = null;
//                    try {
//                        store = storeService.get(id2);
//                    } catch (StorageException e) {
//                        e.printStackTrace();
//                    }
//                    User user2 = ConsoleApplication.session.getUser();
//                    writeObject(bookService.getAll());
//                    writeString("Enter number book");
//                    int id = readInt();
//                    if (!BookValidator.validId(id)) {
//                        writeString("Invalid book number");
//                        return;
//                    }
//
//                    Book book2 = null;
//                    try {
//                        book2 = bookService.getById(id);
//                    } catch (BookException e) {
//                        e.printStackTrace();
//                    }
//                    ConsoleApplication.session.getBasket().add(book2);
//
//                    Book[] all2 = ConsoleApplication.session.getBasket().getAll();
//                    BigDecimal totalPrice2 = getTotalPrice(all2);
//
//                    Order order2 = new Order(user2, store, all2, totalPrice2);
//                    orderService.save(order2);
//                    break;

                case 3:
                    orderService.getAllByUser(ConsoleApplication.session.getUser());
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

    public void removeByOrder()  {
//        writeObject(orderService.getAll());
//        writeString("Enter number");
//        Order order = null;
//        try {
//            order = orderService.getById(readInt());
//        } catch (OrderException e) {
//            e.printStackTrace();
//        }
//        orderService.remove(order);
    }

    public void updateOrderById() {
//        writeObject(orderService.getAll());
//        writeString("Enter id");
//        int id = readInt();
//        Order order = null;
//        try {
//            order = orderService.getById(id);
//        } catch (OrderException e) {
//            e.printStackTrace();
//        }
//        orderService.updateOrderById(order,id);
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
        writeString("Enter id");
        int id = readInt();
        try {
            orderService.getById(id);
        } catch (OrderException e) {
            e.printStackTrace();
        }

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
