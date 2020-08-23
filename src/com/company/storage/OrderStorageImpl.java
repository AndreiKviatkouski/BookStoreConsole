package com.company.storage;
import com.company.domain.Book;
import com.company.domain.Order;
import com.company.domain.Store;
import com.company.domain.User;

import java.util.Arrays;

public class OrderStorageImpl implements OrderStorage {
    private static Order[] orders = new Order[50];

    // TODO: 23.08.2020 Реализовать OrderStorage
    // TODO: 23.08.2020 Реализовать OrderService
    // TODO: 23.08.2020 Реализовать OrderAction
    @Override
    public boolean save(Order order) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                orders[i] = order;
                return true;
            }
        }
        return false;
    }

    @Override
    public Order remove(int id) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getId() == id) {
                Order old = orders[i];
                for (int j = i; j < orders.length; j++) {
                    orders[i] = orders[j + 1];
                }
                return old;
            }
        }
        return null;
    }


    @Override
    public Order remove(Order order) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == order) {
                Order old = orders[i];
                for (int j = i; j < orders.length; j++) {
                    orders[i] = orders[j + 1];
                }
                return old;
            }
        }
        return null;
    }

    @Override
    public Order updateOrderById(Order order, int id) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getId() == id) {
                Order old = orders[i];
                orders[i] = order;
                return old;
            }
        }
        return null;
    }

    @Override
    public void addBook(Book book, int id) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) break;
            if (orders[i].getId() == id) {
                Book[] books = orders[i].getBooks();
                for (int i1 = 0; i1 < books.length; i1++) {
                    if (books[i1] == null) {
                        books[i1] = book;
                    }
                }
            }
        }

    }

    @Override
    public void removeBook(String title, int id) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getId() == id) {
                Book[] books = orders[i].getBooks();
                for (int i1 = 0; i1 < books.length; i1++) {
                    if (books[i1].getTitle().equals(title)) {
                        for (int j = i1; j < books.length - 1; j++) {
                            books[j] = books[j + 1];
                        }
                    }
                }

            }
        }
    }

    @Override
    public Order getById(int id) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getId() == id) ;
            return orders[i];
        }
        return null;
    }

    @Override
    public Order[] getAll() {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null) {
                count++;
            }
        }
        return Arrays.copyOf(orders, count);
    }

    @Override
    public Order[] getAllByUser(User user) {
        int count = 0;
        for (Order order : orders) {
            if (order.getUser().equals(user)) {
                count++;
            }
        }
        return Arrays.copyOf(orders, count);
    }

    @Override
    public Order[] getAllByStore(Store store) {
        int count = 0;
        for (Order order : orders) {
            if (order.getStore().equals(store)) {
                count++;
            }
        }
        return Arrays.copyOf(orders, count);
    }

    public Order[] getAllByStore2(Store store) {
        int count = 0;
        for (Order order : orders) {
            if (order.getStore().equals(store)) {
                count++;
            }
        }
        Order[] orderOld = new Order[count];
        for (int i = 0; i < orderOld.length - 1; i++) {
            orderOld[i] = orders[i + 1];

        }
        return orderOld;
    }


    @Override
    public boolean contains(Order order) {
        for (Order value : orders) {
            if (value.equals(order)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contains(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(User user) {
        for (Order order : orders) {
            if (order.getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains() {
        for (Order order : orders) {
            if (order != null) {
                return true;
            }
        }
        return false;
    }
}
