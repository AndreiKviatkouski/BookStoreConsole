package com.company.console.validator;

public class AuthorValidator {

    public static boolean validId(int id) {
        return id > 0;
    }

    public static boolean validFullName(String fullName) {
        return fullName.length() > 3;
    }
}
