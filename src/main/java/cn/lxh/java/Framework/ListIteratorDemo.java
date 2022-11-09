package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator可以实现在迭代过程对元素的增删改查，只有List集合具备该功能
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

        System.out.println("原list： " + list);
        ListIterator li = list.listIterator();
        while(li.hasNext()){//反向取li.hasPrevious()
            Object obj = li.next();//为什么此处能用Objec接收，是因为add方法中的传入的Object对象
            if(obj.equals("abc2")){
           //     li.add("abc9");//增加一个元素
                li.set("abc22");//修改一个元素
            }
        }
        System.out.println("后list： " + list);
    }
}
