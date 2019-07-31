package cn.lxh.java.DesignStyle.decorator;

/**
 * Created by starlin
 * on 2018/3/18 21:18.
 * 装饰模式
 */
public class Test {
    public static void main(String[] args) {
        Beverage beverage = new GreenTea();
        //开始装饰
        //绿茶里面加入柠檬
        beverage = new Lemon(beverage);
        //绿茶里面加入芒果
        beverage = new Mango(beverage);
        System.out.println(beverage.getDescription() + "价格： " + beverage.cost());
    }
}
