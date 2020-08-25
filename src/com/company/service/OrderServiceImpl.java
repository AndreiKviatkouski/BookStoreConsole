package com.company.service;

import com.company.console.exception.OrderException;
import com.company.domain.Book;
import com.company.domain.Order;
import com.company.domain.Store;
import com.company.domain.User;
import com.company.storage.OrderStorage;
import com.company.storage.OrderStorageImpl;

public class OrderServiceImpl implements OrderService {
    private final OrderStorage orderStorage = new OrderStorageImpl();
    @Override
    public boolean save(Order order) {
        if (orderStorage.contains(order)){
            return  false;
        }
        orderStorage.save(order);
        return true;
    }

    @Override
    public Order remove(int id) throws OrderException {
        if(orderStorage.contains(id)){
           return orderStorage.remove(id);
        }
        throw new OrderException("Could not find order id: " + id);
    }

    @Override
    public Order remove(Order order) throws OrderException {
        if (orderStorage.contains(order)){
            return orderStorage.remove(order);
        }
        throw new OrderException("Could not find order: " + order);
    }

    @Override
    public Order updateOrderById(Order order, int id) throws OrderException {
        if (orderStorage.contains(id)){
            return orderStorage.updateOrderById(order, id);
        }
        throw new OrderException("Could not find order id: " + id);
    }

    @Override
    public void addBook(Book book, int id) {
        if (orderStorage.contains(id)){
            orderStorage.addBook(book, id);
        }
    }

    @Override
    public void removeBook(String title, int id) {
        if (orderStorage.contains(id)){
            orderStorage.removeBook(title, id);
        }
    }

    @Override
    public Order getById(int id) throws OrderException {
        if (orderStorage.contains(id)){
            return orderStorage.getById(id);
        }
        throw new OrderException("Could not find order id: " + id);
    }

    @Override
    public Order[] getAll() {
        return orderStorage.getAll();
    }

    @Override
    public Order[] getAllByUser(User user) {
       return orderStorage.getAllByUser(user);
    }

    @Override
    public Order[] getAllByStore(Store store) {
        return orderStorage.getAllByStore(store);
    }
}
