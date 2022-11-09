package cn.lxh.java.NeiBuClass;

/**
 * ����������
 * Created by starlin
 * on 2015/10/23 20:12.
 */
interface Inter{
    public void method();
}
class Test {
    public static Inter fuction(){
       return new Inter(){//���������ڲ����������������ȡ���ģ�ȡ����ֻ�ܵ��ø���ķ���
            public void method(){
                System.out.println("demo world");
            }
        };
    }
}

public class NiMingNeiBuClass {
    public static void main(String[] args) {
      Test.fuction().method();//TestHttp.fuction() TestHttp���и�static����function�����ú�Ľ���Ƿ���Inter����Ȼ��Inter�������method����
    }
}
