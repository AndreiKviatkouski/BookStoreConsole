package com.company.storage;

import com.company.domain.Author;

import java.util.Arrays;

public class AuthorStorageImpl implements AuthorStorage {
    private static Author[] authors = new Author[50];
    static {
        authors[0]=new Author(1,"Blinov");
    }

    @Override
    public boolean save(Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                authors[i] = author;
                return true;
            }
        }
        return false;
    }

    @Override
    public Author updateAuthor(Author author, int id) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getId() == id) {
                Author oldAuthor = authors[i];
                authors[i].setFullName(author.getFullName());
                return oldAuthor;
            }

        }
        return null;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getId() == id) {
                for (int j = i; j < authors.length - 1; j++) {
                    authors[j] = authors[j + 1];

                }
                break;
            }

        }

    }

    @Override
    public void remove(Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].equals(author)) {
                for (int j = i; j < authors.length - 1; j++) {
                    authors[j] = authors[j + 1];
                }
                break;
            }

        }

    }

    @Override
    public Author getById(int id) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getId() == id) {
                return authors[i];

            }

        }
        throw new RuntimeException("Author with id not found");
    }

    @Override
    public Author[] getAll() {
        int count = 0;
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] != null) {
                count++;
            }

        }
        return Arrays.copyOf(authors, count);
    }

    @Override
    public boolean contains(Author author) {
        for (Author value : authors) {
            if (value != null) {
                return value.equals(author);
            }
        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getId() == (id)) {
                return true;
            }
        }
        return false;
    }
}