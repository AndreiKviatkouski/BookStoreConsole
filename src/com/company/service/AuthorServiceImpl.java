package com.company.service;

import com.company.domain.Author;
import com.company.service.exception.AuthorException;
import com.company.storage.AuthorStorage;
import com.company.storage.AuthorStorageImpl;

public class AuthorServiceImpl implements AuthorService {
    private AuthorStorage authorStorage = new AuthorStorageImpl();

    @Override
    public boolean save(Author author) {
        if (!authorStorage.contains(author)) {
            authorStorage.save(author);
            return true;
        }
        return false;
    }

    @Override
    public Author updateAuthor(Author author, int id) throws AuthorException {
        if (authorStorage.contains(id)) {
            return authorStorage.updateAuthor(author, id);
        }
        throw new AuthorException("Could not find author with ID: " + id);
    }

    @Override
    public void remove(int id) {
        if (authorStorage.contains(id)) {
            authorStorage.remove(id);
        }

    }

    @Override
    public void remove(Author author) {
        if (authorStorage.contains(author)) {
            authorStorage.remove(author);
        }

    }

    @Override
    public Author getById(int id) throws AuthorException {
        if (authorStorage.contains(id)) {
            return authorStorage.getById(id);
        }
        throw new AuthorException("Could not find ID: " + id);
    }

    @Override
    public Author[] getAll() {
        return authorStorage.getAll();
    }

}
