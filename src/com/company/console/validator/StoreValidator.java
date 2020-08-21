package com.company.console.validator;

public class StoreValidator {
    public static boolean validStreet(String street) {
        return street.length() > 3;
    }

    public static boolean validTitle(String title) {
        return title.length() > 0;
    }

    public static boolean validId(int id) {
        return id > 0;
    }

}
