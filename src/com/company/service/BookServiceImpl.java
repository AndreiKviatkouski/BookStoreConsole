package com.company.service;

import com.company.domain.Book;
import com.company.storage.BookStorage;
import com.company.storage.BookStorageImpl;

public class BookServiceImpl implements BookService {

    private BookStorage bookStorage = new BookStorageImpl();

    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();

    }

    @Override
    public boolean save(Book book) {
        if (bookStorage.contains(book)) {
            return false;
        }
        bookStorage.save(book);
        return true;
    }

    @Override
    public String updateTitleById(String title, int id) {
        if (bookStorage.contains(id)) {
            return bookStorage.updateTitleById(title, id);
        }
        return null;
    }

    @Override
    public String updateAuthor(String author, int id) {
        if (bookStorage.contains(id)) {
            return bookStorage.updateAuthor(author, id);
        }
        return null;
    }

    @Override
    public double updatePrice(double price, int id) {
        if (bookStorage.contains(id)) {
            return bookStorage.updatePrice(price, id);
        }
        return 0;
    }

    @Override
    public String updateDescription(String desc, int id) {
        if (bookStorage.contains(id)) {
            return bookStorage.updateDescription(desc, id);
        }
        return null;
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
    public Book getById(int id) {
        if (bookStorage.contains(id)) {
            return bookStorage.getById(id);
        }
        return null;
    }

    @Override
    public Book[] getAll() {
        return bookStorage.getAll();
    }

    @Override
    public Book[] getAllByPrice(double price) {
        return bookStorage.getAllByPrice(price);
    }

    @Override
    public Book[] getAllByAuthor(String author) {
        return bookStorage.getAllByAuthor(author);
    }

    @Override
    public Book getByTitle(String title) {
        if (bookStorage.contains(title)){
            return bookStorage.getByTitle(title);
        }
      return null;
    }
}
