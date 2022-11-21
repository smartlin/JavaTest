package com.starlin.src.Introduction1.AI1

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("A Bad Bank", 1000);   // 创建一个1000日元的银行账户
        new ClientThread(bank).start();
        new ClientThread(bank).start();
    }
}
