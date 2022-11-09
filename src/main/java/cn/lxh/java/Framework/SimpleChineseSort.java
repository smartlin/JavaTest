package cn.lxh.java.Framework;

import java.text.Collator;
import java.util.*;

/**
 * Created by starlin
 * on 2017/02/09 10:48.
 */
public class SimpleChineseSort {
    private final static Comparator CHINA_COMPARE = Collator.getInstance(Locale.CHINA);

    private static void sortList(){
        List<String> list = Arrays.asList("张三","李四","王五");
        Collections.sort(list,CHINA_COMPARE);
        for(String str:list){
            System.out.println(str);
        }
    }

    private static void sortArray(){
        String[] arr = {"张三","李四","王五"};
        Arrays.sort(arr,CHINA_COMPARE);
        for(String str:arr){
            System.out.println(str);
        }
    }
    public static void main(String[] args) {
        sortList();
        sortArray();
    }

}
