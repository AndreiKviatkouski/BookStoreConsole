package com.company.console.validator;

public class AddressValidator {
    public static boolean validStreet(String street) {
        return street.length() > 3;
    }

    public static boolean validHome(int home) {
        return home > 0;
    }
    public  static boolean validId(int id){
        return id>0;
    }
}
