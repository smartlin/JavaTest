package cn.lxh.java.Object;

/**
 * ��дequals����
 * Created by starlin
 * on 2015/10/23 15:20.
 */
class Demo{
    private int num = 4;
    public Demo(int num){
        this.num = num;
    }
    public boolean equals(Object obj){//��дequals����
        if(!(obj instanceof Demo)){//�жϴ���Ķ����Ƿ���ͬһ����
            return false;
        }
        Demo d= (Demo)obj;//����ת��
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
