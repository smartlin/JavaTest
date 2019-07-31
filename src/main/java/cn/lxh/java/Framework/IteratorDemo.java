package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代输出
 * 集合的输出，一定要使用Iterator
 * author:1762
 * Date:2015/09/12
 * Time:19:43
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List<String> all = new ArrayList<String>();
        all.add("Hello");
        all.add("world");
        all.add("Hello1");
        all.add("你好");
//        Iterator<String> itr = all.iterator();
//        while(itr.hasNext()){//hasNext() 判断是否有数据
//            String str = itr.next();//next()取得数据
//            System.out.println(str);
//        }
        //输出集合另外一种写法,for循环结束后 itr释放了内存
        for(Iterator<String> itr = all.iterator();itr.hasNext();){
            String str = itr.next();//next()取得数据
            System.out.println(str);
        }
    }
}
