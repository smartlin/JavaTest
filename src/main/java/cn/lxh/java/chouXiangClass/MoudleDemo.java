package cn.lxh.java.chouXiangClass;

/**
 * 模板设计模式
 * 抽象类
 * Created by starlin
 * on 2015/10/07 19:28.
 */
abstract class Demo{
    public static final int EAT = 1;
    public static final int SLEEP = 5;
    public static final int WORK = 7;
    public abstract void eat();
    public abstract void sleep();
    public abstract void work();
    public void fun(int num) {
        switch (num) {
            case EAT:
                this.eat();
                break;
            case SLEEP:
                this.sleep();
                break;
            case WORK:
                this.work();
                break;
        }
    }

}
class Roobrt extends Demo{
    @Override
    public void eat() {
        System.out.println("机器人正在补充能量");
    }
    @Override
    public void sleep() {

    }
    @Override
    public void work() {
        System.out.println("机器人正在工作");
    }
}
class Human extends Demo{
    @Override
    public void eat() {
        System.out.println("人正在吃饭");
    }
    @Override
    public void sleep() {
        System.out.println("人正在睡觉");
    }
    @Override
    public void work() {
        System.out.println("人正在工作");
    }
}
class Pig extends Demo{
    @Override
    public void eat() {
        System.out.println("猪正在吃食");
    }
    @Override
    public void sleep() {
        System.out.println("猪正在睡觉");
    }
    @Override
    public void work() {

    }
}
public class MoudleDemo {
    public static void main(String[] args) {
        fun(new Roobrt());
    }
    public static void fun(Demo d){
        d.fun(Demo.EAT);
        d.fun(Demo.WORK);
        d.fun(Demo.SLEEP);
    }
}
