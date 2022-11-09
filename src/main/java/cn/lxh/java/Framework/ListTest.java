package cn.lxh.java.Framework;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * arrayList��linkedList��vector
 * ���ּ��ϲ��롢ɾ������ȡ�ٶȶԱ�
 */
public class ListTest {
    private static final int COUNT = 100000;
    
    private static ArrayList arrayList = new ArrayList<>();
    private static LinkedList linkedList = new LinkedList<>();
    private static Vector vector = new Vector<>();
    
    public static void insertToList(List list){
        long startTime = System.currentTimeMillis();

        for(int i = 0 ; i < COUNT ; i++){
            list.add(0,i);
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("���� " + COUNT + "Ԫ��" + getName(list) + "���� " + (endTime - startTime) + " ����");
    }
    
    public static void deleteFromList(List list){
        long startTime = System.currentTimeMillis();
        
        for(int i = 0 ; i < COUNT ; i++){
            list.remove(0);
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("ɾ��" + COUNT + "Ԫ��" + getName(list) + "���� " + (endTime - startTime) + " ����");
    }
    
    public static void readList(List list){
        long startTime = System.currentTimeMillis();
        
        for(int i = 0 ; i < COUNT ; i++){
            list.get(i);
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("��ȡ" + COUNT + "Ԫ��" + getName(list) + "���� " + (endTime - startTime) + " ����");
    }

    private static String getName(List list) {
        String name = "";
        if(list instanceof ArrayList){
            name = "ArrayList";
        }
        else if(list instanceof LinkedList){
            name = "LinkedList";
        }
        else if(list instanceof Vector){
            name = "Vector";
        }
        return name;
    }
    
    public static void main(String[] args) {
        insertToList(arrayList);
        insertToList(linkedList);
        insertToList(vector);
        
        System.out.println("--------------------------------------");
        
        readList(arrayList);
        readList(linkedList);
        readList(vector);
        
        System.out.println("--------------------------------------");
        
        deleteFromList(arrayList);
        deleteFromList(linkedList);
        deleteFromList(vector);
    }
}