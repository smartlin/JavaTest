package cn.lxh.java.Framework;

import java.util.*;

/**
 * Map和List使用
 * Created by starlin
 * on 2015/10/30 21:40.
 */
class Student1{
    private String id;
    private int age;
    public Student1(String id,int age){
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.id + "=====>" + this.age;
    }
}

public class MapDemo4 {
    public static void main(String[] args) {
        demo();
    }
    public static void demo(){
        Map<String,List<Student1>> school = new HashMap<String,List<Student1>>();
        List<Student1> room1 = new ArrayList<Student1>();
        List<Student1> room2 = new ArrayList<Student1>();
        school.put("room1",room1);
        school.put("room2",room2);
        room1.add(new Student1("zhangsan",20));
        room1.add(new Student1("lishi",30));
        room2.add(new Student1("zhaoliu",18));
        room2.add(new Student1("wangwu",25));
//        Set<String> set =  school.keySet();
//        Iterator<String> it = set.iterator();
        Iterator<String> it = school.keySet().iterator();//上面2句可以合成一句
        while(it.hasNext()){
            String roomName = it.next();
            List<Student1> room = school.get(roomName);
            System.out.println(roomName);
            getStudentInfo(room);
        }
    }
    public static void getStudentInfo(List<Student1> list){
        Iterator<Student1> it = list.iterator();
        while (it.hasNext()){
            Student1 s = it.next();
            System.out.println(s);
        }
    }
}
