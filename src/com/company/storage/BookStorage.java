package com.company.storage;

import com.company.domain.Book;

public interface BookStorage {
    boolean save(Book book);

    String updateTitleById(String title, int id);
    String updateAuthor(String author, int id);
    double updatePrice(double price, int id);
    String updateDescription(String desc, int id);

    void remove(int id);
    void remove(Book book);

    Book getById(int id);
    Book[] getAll();
    Book[] getAllByPrice(double price);
    Book[] getAllByAuthor(String author);
    Book getByTitle(String title);

    boolean contains(Book book);
    boolean contains(int id);
    boolean contains(String title);
}
