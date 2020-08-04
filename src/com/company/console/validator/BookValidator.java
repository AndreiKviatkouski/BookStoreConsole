package com.company.console.validator;

public class BookValidator {
    public static boolean validId(int id) {
        return id > 0;
    }

    public static boolean validTitle(String title) {
        return title.length() > 3;
    }

    public static boolean validAuthor(String author) {
        return author.length() > 3;
    }


    public static boolean validDescription(String desk) {
        return desk.length() > 3;
    }

    public static boolean validPrice(double price) {
        return price > 0;
    }
}
