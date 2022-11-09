package cn.lxh.java.Interface;

/**
 * Created by starlin
 * on 2015/09/20 14:01.
 */
interface Friut{
    public void eat();
}
class Apple implements Friut{
    public void eat(){
        System.out.println("吃苹果");
    }
}
class Orange implements Friut{
    public void eat(){
        System.out.println("吃橘子");
    }
}
class FactoryDemo{
    public static Friut getInstance(String classname){
        if(classname.equals("Apple")){
            return new Apple();
        }else if(classname.equals("Orange")){
            return new Orange();
        }else{
            return null;
        }
    }
}
public class Factory {
    public static void main(String[] args) {
        Friut f = FactoryDemo.getInstance("Orange");
        f.eat();
    }
}
