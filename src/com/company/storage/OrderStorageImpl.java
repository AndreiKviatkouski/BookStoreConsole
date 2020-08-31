package com.company.storage;

import com.company.domain.Book;
import com.company.domain.Order;
import com.company.domain.Store;
import com.company.domain.User;

import java.util.Arrays;

import static com.company.domain.Status.ACTIVE;
import static com.company.domain.Type.PICKUP;

public class OrderStorageImpl implements OrderStorage {
    private static Order[] orders = new Order[50];
    private static UserStorage userStorage = new UserStorageImpl();
    private static StoreStorage storeStorage = new StoreStorageImpl();
    private static BookStorage bookStorage = new BookStorageImpl();
    private static AddressStorage addressStorage = new AddressStorageImpl();

    static {
        orders[0] = new Order(1, userStorage.getById(1), addressStorage.getById(1), storeStorage.get(1), ACTIVE, PICKUP, bookStorage.getAll(), bookStorage.getById(1).getPrice());
    }

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
        Order[] orders = new Order[count];
        int ordersIndex = 0;
        for (Order order : orders) {
            if(order.getUser().equals(user)){
                orders[ordersIndex++] = order;
            }
        }
        return orders;
    }

    @Override
    public Order[] getAllByStore(Store store) {
        int count = 0;
        for (Order order : orders) {
            if (order.getStore().equals(store)) {
                count++;
            }
        }
        Order[]orders1 = new Order[count];
        int index =0 ;
        for (Order order : orders1) {
            if (order.getStore().equals(store)){
                orders1[index++]=order;
            }
        }
        return orders1;
    }

    @Override
    public boolean contains(Order order) {
        for (Order value : orders) {
            if (value == null)break;
            if (value.equals(order)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        for (Order order : orders) {
            if (order==null)break;
            if (order.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(User user) {
        for (Order order : orders) {
            if (order==null)break;
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
