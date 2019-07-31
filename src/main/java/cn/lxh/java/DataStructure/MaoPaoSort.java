package cn.lxh.java.DataStructure;

/**
 * 冒泡排序
 * Created by starlin
 * on 2015/10/07 13:43.
 */

public class MaoPaoSort {
    public static void bubbleSort(int data[]){
        for(int k = 0;k<data.length;k++) {//控制外面循环次数
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
       }
    }
    public static void print(int[] num){
        for(int i=0;i<num.length;i++){
            System.out.print(num[i] + "、");
        }
    }
    public static void main(String[] args) {
        int [] data = new int[]{2,5,7,1,3,8,12};
        bubbleSort(data);
        print(data);
    }

}
