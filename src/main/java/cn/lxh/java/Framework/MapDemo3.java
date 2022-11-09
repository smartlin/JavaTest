package cn.lxh.java.Framework;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 计算指定字符串各字母的个数
 * Created by starlin
 * on 2015/10/30 20:39.
 */
public class MapDemo3 {
    public static void main(String[] args) {
        String s = charCount("abcdefaadet");
        System.out.println(s);
    }
    public static String charCount(String str){
        char[] ch = str.toCharArray();
        TreeMap<Character,Integer> treeMap = new TreeMap<Character,Integer>();
        for(int i=0;i<str.length();i++){
            Integer integer = treeMap.get(ch[i]);
            if(integer==null){
                treeMap.put(ch[i],1);
            }else{
                treeMap.put(ch[i],integer + 1);
            }

        }
     //   System.out.println(treeMap);
        StringBuilder stringBuilder = new StringBuilder();
        Set<Map.Entry<Character,Integer>> set = treeMap.entrySet();
        Iterator<Map.Entry<Character,Integer>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<Character,Integer> mape = it.next();
            Character character = mape.getKey();
            Integer integer = mape.getValue();
            stringBuilder.append(character + "("+ integer + ")");
        }
    //  System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
