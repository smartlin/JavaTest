package cn.lxh.java.DuoTai;

/**
 * Created by starlin
 * on 2015/10/23 11:29.
 */
abstract class Animal{
    public abstract void eat();
}
class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("吃猫食");
    }
    public void catchMouse(){
        System.out.println("抓老鼠");
    }
}
class Dog extends Animal{

    @Override
    public void eat() {
        System.out.println("吃骨头");
    }
    public void lookDoor(){
        System.out.println("看门");
    }
}
public class AnimalDuoTai {
    public static void main(String[] args) {
        fun(new Cat());
        fun(new Dog());
    }
    public static void fun(Animal animal){
        animal.eat();
        if(animal instanceof Cat){
            Cat c = (Cat)animal;
            c.catchMouse();
        }

    }
}
