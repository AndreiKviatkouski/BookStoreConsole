package com.company.service;

import com.company.domain.Author;


public interface AuthorService {
    boolean save(Author author);

    Author updateAuthor(Author author, int id);

    void remove(int id);

    void remove(Author author);

    Author getById(int id);

    Author[] getAll();
}
