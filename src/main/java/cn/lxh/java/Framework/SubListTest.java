package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by starlin
 * on 2017/08/02 22:54.
 */
public class SubListTest {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(11);
        arrayList.add(14);
        arrayList.add(18);
        arrayList.add(10);
        System.out.println("arrayList-------------->"+arrayList);
        //����ArrayList�е�subList�������ɵ��µ�list���ڲ����õĻ���ԭ��������elementData
        //����ı�subList�е�ֵ����list�е�ֵҲ����Ÿı䡣
        List<Integer> list = arrayList.subList(2, 6);
        System.out.println("list---------------->"+list);
        list.set(2, 50);
        System.out.println("arrayList---after----------->"+arrayList);
        System.out.println("list--------after------->"+list);
    }
}
