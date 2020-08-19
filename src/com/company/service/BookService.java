package com.company.service;

import com.company.domain.Author;
import com.company.domain.Book;
import com.company.service.exception.BookException;
import com.company.service.exception.UserException;

import java.math.BigDecimal;

public interface BookService {
    boolean save(Book book);

    String updateTitleById(String title, int id) throws UserException, BookException;
    Author updateAuthor(Author author, int id) throws BookException;
    BigDecimal updatePrice(BigDecimal price, int id) throws BookException;
    String updateDescription(String desc, int id) throws BookException;

    void remove(int id);
    void remove(Book book);

    Book getById(int id) throws BookException;
    Book[] getAll();
    Book[] getAllByPrice(BigDecimal price);
    Book[] getAllByAuthor(String author);
    Book getByTitle(String title) throws BookException;
}
