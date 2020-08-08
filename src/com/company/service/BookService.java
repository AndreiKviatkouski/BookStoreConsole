package com.company.service;

import com.company.domain.Author;
import com.company.domain.Book;

import java.math.BigDecimal;

public interface BookService {
    boolean save(Book book);

    String updateTitleById(String title, int id);
    Author updateAuthor(Author author, int id);
    BigDecimal updatePrice(BigDecimal price, int id);
    String updateDescription(String desc, int id);

    void remove(int id);
    void remove(Book book);

    Book getById(int id);
    Book[] getAll();
    Book[] getAllByPrice(BigDecimal price);
    Book[] getAllByAuthor(String author);
    Book getByTitle(String title);
}
