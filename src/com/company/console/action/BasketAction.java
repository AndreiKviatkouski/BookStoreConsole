package com.company.console.action;

import com.company.console.ConsoleApplication;
import com.company.domain.Book;
import com.company.service.BookService;
import com.company.service.BookServiceImpl;
import static com.company.console.util.Reader.*;
import static com.company.console.util.Writer.*;

public class BasketAction {
    public  void findAll(){
        Book[] all = ConsoleApplication.session.getBasket().getAll();
        for (int i = 0; i < all.length; i++) {
            writeString(all[i].getTitle());
        }
    }

}
