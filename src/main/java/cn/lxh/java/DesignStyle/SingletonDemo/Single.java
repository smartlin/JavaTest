package cn.lxh.java.DesignStyle.SingletonDemo;

/**
 * Created by starlin
 * on 2015/10/22 16:02.
 */
class Student{
    private int num;

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    private Student(){
    }
    private static Student s = new Student();
    public static Student getInstance(){
        return s;
    }
}
public class Single {
    public static void main(String[] args) {
        Student s = Student.getInstance();
        s.setNum(30);
        Student s1 = Student.getInstance();
        System.out.println(s1.getNum());
    }
}

