package com.starlin.src.Introduction1.Printer;

public class Main {
    public static void main(String[] args) {
        new Thread(new Printer("Good!")).start();
        new Thread(new Printer("Nice!")).start();
    }
}
