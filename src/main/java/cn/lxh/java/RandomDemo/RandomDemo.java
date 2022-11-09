package cn.lxh.java.RandomDemo;

import java.util.Random;

/**
 * 利用随机数实现36选7
 * Created by starlin
 * on 2015/10/10 11:28.
 */
public class RandomDemo {
    public static void main(String[] args) {
        int [] data = new int[7];
        int foot = 0;
        Random rand = new Random();
        while (foot < 7){
            int t = rand.nextInt(37);
            if(!IsReapeat(data,t)){
                data[foot++] = t;
            }
        }
        java.util.Arrays.sort(data);
        for(int i = 0;i<data.length;i++){
            System.out.print(data[i] + "、");
        }

    }
    public static boolean IsReapeat(int [] temp,int num){
        if(num==0){//选中的数字不能为0
            return true;
        }
        for(int i = 0;i<temp.length;i++){
            if(temp[i]==num){
                return true;
            }
        }
        return false;
    }
}
