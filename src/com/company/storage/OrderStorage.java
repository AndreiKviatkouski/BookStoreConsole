package com.company.storage;

import com.company.domain.Book;
import com.company.domain.Order;
import com.company.domain.Store;
import com.company.domain.User;

public interface OrderStorage {


    boolean save(Order order);

    Order remove(int id);

    Order remove(Order order);

    Order updateOrderById(Order order, int id);

    void addBook(Book book, int id);

    void removeBook(String title, int id);

    Order getById(int id);

    Order[] getAll();

    Order[] getAllByUser(User user);

    Order[] getAllByStore(Store store);

    boolean contains(Order order);

    boolean contains(int id);

    boolean contains(User user);

    boolean contains();

}