package com.company.storage;

import com.company.domain.Author;
import com.company.domain.Book;

import java.math.BigDecimal;

public interface AuthorStorage {
    boolean save(Author author);

    Author updateAuthor(Author author, int id);
    void remove(int id);
    void remove(Author author);

    Author getById(int id);
    Author[] getAll();

    boolean contains(Author author);
    boolean contains(int id);
}
