package cn.lxh.java.NeiBuClass;

/**
 * ִ��˳�򣺾�̬����� > �������� > ���췽��
 * Created by starlin
 * on 2015/10/22 14:38.
 */
class DaimaKuaiTest{
    public DaimaKuaiTest(){//���췽��
        System.out.println("d");
    }
    static {//��̬�����
        System.out.println("a");
    }
    {//��������
        System.out.println("b");
    }
}
public class DaimaKuai {
    public static void main(String[] args) {
        DaimaKuaiTest d = new DaimaKuaiTest();
        System.out.println("c");
    }
}
