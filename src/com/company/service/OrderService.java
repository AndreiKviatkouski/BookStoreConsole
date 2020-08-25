package com.company.service;

import com.company.console.exception.OrderException;
import com.company.domain.Book;
import com.company.domain.Order;
import com.company.domain.Store;
import com.company.domain.User;

public interface OrderService {
    boolean save(Order order);

    Order remove(int id) throws OrderException;

    Order remove(Order order) throws OrderException;

    Order updateOrderById(Order order, int id) throws OrderException;

    void addBook(Book book, int id) throws OrderException;

    void removeBook(String title, int id) throws OrderException;

    Order getById(int id) throws OrderException;

    Order[] getAll();
    Order[] getAllByUser(User user);
    Order[] getAllByStore(Store store);
}
