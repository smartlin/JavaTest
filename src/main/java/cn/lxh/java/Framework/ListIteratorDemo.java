package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator����ʵ���ڵ������̶�Ԫ�ص���ɾ�Ĳ飬ֻ��List���Ͼ߱��ù���
 * Created by starlin
 * on 2015/10/31 18:11.
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("abc1");
        list.add("abc2");
        list.add("abc4");
        list.add("abc8");

        System.out.println("ԭlist�� " + list);
        ListIterator li = list.listIterator();
        while(li.hasNext()){//����ȡli.hasPrevious()
            Object obj = li.next();//Ϊʲô�˴�����Objec���գ�����Ϊadd�����еĴ����Object����
            if(obj.equals("abc2")){
           //     li.add("abc9");//����һ��Ԫ��
                li.set("abc22");//�޸�һ��Ԫ��
            }
        }
        System.out.println("��list�� " + list);
    }
}
