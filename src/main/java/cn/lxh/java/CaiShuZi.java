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
        System.out.println("�������������Ϊ��" + x);
        Scanner sc = new Scanner(System.in);
        System.out.println("�Ƿ�ʼ��Ϸ��yes or no");
        String answer = sc.next();
        while (answer.equalsIgnoreCase("yes")) {
            System.out.println("��������һ��������");
            int y = sc.nextInt();
            System.out.println("�����������Ϊ��" + y);
            if (x > y) {
                System.out.println("����Ӯ��");
            }
            if (x < y) {
                System.out.println("��Ӯ��");
            }
            if (x == y) {
                System.out.println("ƽ��");
            }
            System.out.println("�Ƿ�ʼ��һ�֣�yes or no");
            answer = sc.next();
        }
        System.out.println("���˳�����Ϸ");
        System.exit(0);
    }

}
