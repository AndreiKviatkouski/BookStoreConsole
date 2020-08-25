package com.company.service;

import com.company.domain.Author;
import com.company.console.exception.AuthorException;


public interface AuthorService {
    boolean save(Author author);

    Author updateAuthor(Author author, int id) throws AuthorException;

    void remove(int id);

    void remove(Author author);

    Author getById(int id) throws AuthorException;

    Author[] getAll();
}
