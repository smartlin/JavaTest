package cn.lxh.java.DesignStyle.decorator;

/**
 * Created by starlin
 * on 2018/3/18 21:18.
 * װ��ģʽ
 */
public class Test {
    public static void main(String[] args) {
        Beverage beverage = new GreenTea();
        //��ʼװ��
        //�̲������������
        beverage = new Lemon(beverage);
        //�̲��������â��
        beverage = new Mango(beverage);
        System.out.println(beverage.getDescription() + "�۸� " + beverage.cost());
    }
}
