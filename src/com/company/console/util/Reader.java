package com.company.console.util;

import java.util.Scanner;

public class Reader {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt(){
        return scanner.nextInt();
    }

    public static double readDouble(){
        return scanner.nextDouble();
    }

    public static String readString(){
        return scanner.next();
    }
}
