package cn.lxh.java.NeiBuClass;

/**
 * �����ж����ڲ���
 * Created by starlin
 * on 2015/10/05 16:05.
 */
class Outer2{
    private String msg = "Hello world";
    public void fun(final int num){//JDK1.8֮����Ҫ��ʹ��final
        final double score = 99.9;//�ڲ��ඨ���ڷ����ڣ����ʷ����е�����ʱ����Ҫ����Ϊfinal
        class Inner{
            public void print(){
                System.out.println("���ԣ�" + Outer2.this.msg);
                System.out.println("����������" + num);
                System.out.println("��������" + score);
            }
        }
        new Inner().print();
    }
}
public class FuncitonNeiBuClass {
    public static void main(String[] args) {
        Outer2 out = new Outer2();
        out.fun(100);
    }
}
