package cn.lxh.java.string;

/**
 * ��װ��
 * �����������͡���װ��------->����ת��ΪString��������Integer.toString(Integer����)
 * String��ת��Ϊ--->�����������͡���װ��:���ð�װ���parseXX����
 * Created by starlin
 * on 2015/10/18 20:41.
 */
public class BaoZhuangClass {
    public static void main(String[] args) {
        Integer i = 10;//�Զ�װ�䣬10Ĭ�Ͼ��� new Integer(10),ֱ�Ӱ�i������������Զ�����
        String s1 = i.toString(i);//����װ��ת��Ϊ�ַ���
        System.out.println(s1);
        System.out.println(Integer.parseInt(s1));//���ַ���ת��Ϊ��װ��parseXX()
    }
}
