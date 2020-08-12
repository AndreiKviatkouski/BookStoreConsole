package com.company.console.validator;

public class UserValidator {
    public static boolean validId(int id) {
        return id > 0;
    }

    public static boolean validName(String name) {
        return name.length() > 3;
    }

    public static boolean validPassword(String password) {
        return password.length() > 3;
    }

    public static boolean validLogin(String name) {
        return name.length() > 3;
    }
}
