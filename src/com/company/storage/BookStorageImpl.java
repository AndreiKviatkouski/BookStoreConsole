package com.company.storage;

import com.company.domain.Author;
import com.company.domain.Book;

import java.math.BigDecimal;
import java.util.Arrays;


public class BookStorageImpl implements BookStorage {
    private static Book[] books = new Book[50];
    private static AuthorStorage authorStorage = new AuthorStorageImpl();

    static {
        books[0] = new Book(1, "JAVA 8", "Java programming methods",BigDecimal.valueOf(10.12), authorStorage.getById(1));
    }

    @Override
    public boolean save(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return true;
            }
        }
        return false;
    }

    @Override
    public String updateTitleById(String title, int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                String old = books[i].getTitle();
                books[i].setTitle(title);
                return old;
            }
        }
        return null;
    }

    @Override
    public Author updateAuthor(Author author, int id) {
//        for (int i = 0; i < books.length; i++) {
//            if (books[i].getId() == id) {
//                String old = books[i].getAuthor();
//                books[i].setAuthor(author);
//                return old;
//            }
//        }
        return null;
    }

    @Override
    public BigDecimal updatePrice(BigDecimal price, int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                BigDecimal priceOld = books[i].getPrice();
                books[i].setPrice(price);
                return priceOld;
            }
        }
        return null;
    }

    @Override
    public String updateDescription(String desc, int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                String descOld = books[i].getDescription();
                books[i].setDescription(desc);
                return descOld;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                for (int j = i; j < books.length + 1; j++) {
                    books[j] = books[j + 1];
                }
                break;
            }
        }
    }

    @Override
    public void remove(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book)) {
                for (int j = i; j < books.length + 1; j++) {
                    books[j] = books[j + 1];
                }
                break;
            }
        }

    }

    @Override
    public Book getById(int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                return books[i];
            }
        }
        return null;
    }

    @Override
    public Book[] getAll() {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                count++;
            }
        }
//        Book[] bookNew = new Book[count];
//        for (int i = 0; i <bookNew.length; i++) {
//            bookNew[i] = books[i];
//        }
        return Arrays.copyOf(books, count);
    }

    @Override
    public Book[] getAllByPrice(BigDecimal price) {//
        int count = 0;
        for (Book book : books) {
            if (book.getPrice().equals(price)) {
                count++;
                return Arrays.copyOf(books, count);
            }
        }
        return null;
    }

    @Override
    public Book[] getAllByAuthor(String author) {//
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                count++;
                return Arrays.copyOf(books, count);
            }

        }
        return null;
    }

    @Override
    public Book getByTitle(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    @Override
    public boolean contains(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].equals(book)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
