package cn.lxh.java;

import java.util.Scanner;

/**
 * Created by starlin
 * on 2015/10/15 15:36.
 */
class Computer{
    public int cshow(){
        Scanner sc = new Scanner(System.in);
        int cnum = (int) (Math.random()*100);
        return cnum;
    }
}
public class CaiShuZi {
    public static void main(String[] args) {
        diceRoll();
    }
    public static void diceRoll(){
        Computer c = new Computer();
        int x = c.cshow();
        System.out.println("电脑输入的数字为：" + x);
        Scanner sc = new Scanner(System.in);
        System.out.println("是否开始游戏？yes or no");
        String answer = sc.next();
        while (answer.equalsIgnoreCase("yes")) {
            System.out.println("请你输入一个整数：");
            int y = sc.nextInt();
            System.out.println("你输入的数字为：" + y);
            if (x > y) {
                System.out.println("电脑赢了");
            }
            if (x < y) {
                System.out.println("你赢了");
            }
            if (x == y) {
                System.out.println("平手");
            }
            System.out.println("是否开始下一轮？yes or no");
            answer = sc.next();
        }
        System.out.println("你退出了游戏");
        System.exit(0);
    }

}
