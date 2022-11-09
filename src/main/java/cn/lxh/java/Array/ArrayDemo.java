package cn.lxh.java.Array;

/**
 * Created by starlin
 * on 2015/10/05 21:12.
 */
class Array{
    private int [] data;
    private int foot;//存放数组的脚标
    public Array(int len){
        this.data = new int[len];
    }
    public boolean add(int num){//增加数据
        if(this.foot<this.data.length){
            this.data[this.foot++] = num;
            return true;

        }
        return false;
    }

    public int[] getData() {//取出数据
        return data;
    }
}
//数组排序
class ArraySort extends Array{
    public ArraySort(int len) {
        super(len);
    }
    @Override
    public int[] getData() {
        java.util.Arrays.sort(super.getData());//改地方一定要加super，只写getData（）,无法调数据 因为数组存放在父类中
        return super.getData();
    }
}
//反转 也可以说是转置
class Resvers extends Array{
    public Resvers(int len) {
        super(len);
    }
    @Override
    public int[] getData() {
        int center = super.getData().length/2;
        int head = 0;
        int tail = super.getData().length - 1 ;
        for(int i = 0;i < center ;i++){
            int temp = super.getData()[head];
            super.getData()[head] = super.getData()[tail];
            super.getData()[tail] = temp ;
            head++;
            tail--;
        }
        return super.getData();
    }
}
public class ArrayDemo {
    public static void main(String[] args) {
        //ArraySort arr = new ArraySort(5);
        Resvers arr = new Resvers(5);
        System.out.println(arr.add(30));
        System.out.println(arr.add(10));
        System.out.println(arr.add(20));
        System.out.println(arr.add(40));
        System.out.println(arr.add(50));
        int[] temp = arr.getData();
        for(int i = 0;i<temp.length;i++){
            System.out.println(temp[i]);
        }
    }
}
