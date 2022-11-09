package cn.lxh.java.string;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest2 {
    public static void main(String[] args) {  
        Set<Person1> set = new TreeSet<Person1>(new PersonComparator());
        Person1 p1 =  new Person1(10);
        Person1 p2 =  new Person1(20);
        Person1 p3 =  new Person1(30);
        Person1 p4 =  new Person1(40);
        set.add(p1);  
        set.add(p2);  
        set.add(p3);  
        set.add(p4);         
        for(Iterator<Person1> iterator = set.iterator(); iterator.hasNext();){
            System.out.print(iterator.next().score+" ");  
        }  
    }  
}  
class Person1{
    int score;  
    public Person1(int score){
        this.score = score;  
    }     
    @Override
    public String toString(){
        return String.valueOf(this.score);  
    }  
}  
class PersonComparator implements Comparator<Person1> {
    @Override  
    public int compare(Person1 o1, Person1 o2) {
        return o1.score - o2.score;  
    }      
}  
