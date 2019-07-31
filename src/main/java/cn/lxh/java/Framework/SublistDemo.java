package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.List;

/**
 * list分割
 * Created by starlin
 * on 2016/04/19 9:50.
 */
public class SublistDemo {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=1;i<1001;i++)
            list.add(i);
        int count=list.size()/20;
        List<Integer> subList = new ArrayList<>();
        for(int i=0;i<20;i++){
            subList = list.subList(i*count,count*(i+1));
            System.out.println(subList);
        }

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for(int i=0;i<100;i++){
            list1.add(i);
        }
        lists.add(list1);

    }

}
