package cn.lxh.java.Object;

/**
 * 重写equals方法
 * Created by starlin
 * on 2015/10/23 15:20.
 */
class Demo{
    private int num = 4;
    public Demo(int num){
        this.num = num;
    }
    public boolean equals(Object obj){//重写equals方法
        if(!(obj instanceof Demo)){//判断传入的对象是否是同一类型
            return false;
        }
        Demo d= (Demo)obj;//向下转型
        return d.num == this.num;
    }
}
class Person{

}
public class equalsDemo {
    public static void main(String[] args) {
        Demo d = new Demo(4);
        Demo d1 = new Demo(4);
        Person p = new Person();
        System.out.println(d.equals(p));
    }
}
