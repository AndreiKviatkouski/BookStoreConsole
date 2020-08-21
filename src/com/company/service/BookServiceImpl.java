package com.company.service;

import com.company.domain.Author;
import com.company.domain.Book;
import com.company.service.exception.BookException;
import com.company.storage.BookStorage;
import com.company.storage.BookStorageImpl;


import java.math.BigDecimal;

public class BookServiceImpl implements BookService {
  private BookStorage bookStorage = new BookStorageImpl();

    @Override
    public boolean save(Book book) {
        if (bookStorage.contains(book)) {
            return false;
        }
        bookStorage.save(book);
        return true;
    }

    @Override
    public String updateTitleById(String title, int id) throws BookException {
        if (bookStorage.contains(id)) {
            return bookStorage.updateTitleById(title, id);
        }
        throw new BookException("Could not find title with ID: " + id);
    }

    @Override
    public Author updateAuthor(Author author, int id) throws BookException {
        if (bookStorage.contains(id)) {
            return bookStorage.updateAuthor(author, id);
        }
        throw new BookException("Could not find author with ID: " + id);
    }

    @Override
    public BigDecimal updatePrice(BigDecimal price, int id) throws BookException {
        if (bookStorage.contains(id)) {
            return bookStorage.updatePrice(price, id);
        }
        throw new BookException("Could not find price with ID: " + id);
    }

    @Override
    public String updateDescription(String desc, int id) throws BookException {
        if (bookStorage.contains(id)) {
            return bookStorage.updateDescription(desc, id);
        }
        throw new BookException("Could not find description with ID: " + id);
    }

    @Override
    public void remove(int id) {
        if (bookStorage.contains(id)) {
            bookStorage.remove(id);
        }

    }

    @Override
    public void remove(Book book) {
        if (bookStorage.contains(book)) {
            bookStorage.remove(book);
        }
    }

    @Override
    public Book getById(int id) throws BookException {
        if (bookStorage.contains(id)) {
            return bookStorage.getById(id);
        }
        throw new BookException("Could not find ID: " + id);
    }

    @Override
    public Book[] getAll() {
        return bookStorage.getAll();
    }

    @Override
    public Book[] getAllByPrice(BigDecimal price) {
        return bookStorage.getAllByPrice(price);
    }

    @Override
    public Book[] getAllByAuthor(String author) {
        return bookStorage.getAllByAuthor(author);
    }

    @Override
    public Book getByTitle(String title) throws BookException {
        if (bookStorage.contains(title)){
            return bookStorage.getByTitle(title);
        }
        throw new BookException("Could not find Title: " + title);
    }
}
