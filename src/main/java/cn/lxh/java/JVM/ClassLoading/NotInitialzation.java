package cn.lxh.java.JVM.ClassLoading;

import java.io.Serializable;

/**
 * Created by starlin
 * on 2018/8/26 23:18.
 * �������ø���ľ�̬�ֶΣ����಻�ᱻ��ʼ��
 */
public class NotInitialzation implements Serializable {

    public static void main(String[] args) {
        //�������ø���ľ�̬�ֶΣ����಻�ᱻ��ʼ��
        System.out.println(SuperClass.value);

        //ͨ�����鶨���������࣬���ᴥ������ĳ�ʼ��
        SuperClass[] superClasses = new SuperClass[10];

        //�����ڱ���׶λ���������ĳ����أ������ϲ�û��ֱ�����õ����峣�����࣬��˲��ᴥ�����峣����ĳ�ʼ��
        System.out.println(ConstClass.VALUE);
    }
}
