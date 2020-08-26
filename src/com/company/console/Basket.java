package com.company.console;

import com.company.domain.Book;

import java.util.Arrays;

public class Basket {
    private Book[] books = new Book[10];

    public void add(Book book){
        for (int i = 0; i < books.length; i++) {
            if (books[i]==null){
                books[i] = book;
                break;
            }
        }
    }

    public Book[] getAll(){
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i]!=null){
                count++;
            }
        }
    return Arrays.copyOf(books, count);
    }

}
