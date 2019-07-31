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
        //调用ArrayList中的subList方法生成的新的list，内部引用的还是原来的数组elementData
        //如果改变subList中的值，主list中的值也会跟着改变。
        List<Integer> list = arrayList.subList(2, 6);
        System.out.println("list---------------->"+list);
        list.set(2, 50);
        System.out.println("arrayList---after----------->"+arrayList);
        System.out.println("list--------after------->"+list);
    }
}
