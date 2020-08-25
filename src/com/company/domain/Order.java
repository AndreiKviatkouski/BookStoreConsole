package com.company.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class Order {
    private static int incId = 1;
    private int id = incId++;

    private User user;
    private Address address;
    private Store store;

    private Status status = Status.ACTIVE;
    private Type type;

    private Book[] books;
    private BigDecimal totalPrice;

    public Order() {
    }

    public Order(User user, Store store, Book[] books, BigDecimal totalPrice) {
        this.user = user;
        this.store = store;
        this.books = books;
        this.totalPrice = totalPrice;
        this.type = Type.PICKUP;
    }

    public Order(User user, Address address, Book[] books, BigDecimal totalPrice) {
        this.user = user;
        this.address = address;
        this.books = books;
        this.totalPrice = totalPrice;
        this.type = Type.DELIVERY;
    }

    public Order(int id, User user, Address address, Store store, Status status, Type type, Book[] books, BigDecimal totalPrice) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.store = store;
        this.status = status;
        this.type = type;
        this.books = books;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(user, order.user) &&
                Arrays.equals(books, order.books);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(user);
        result = 31 * result + Arrays.hashCode(books);
        return result;
    }


}
