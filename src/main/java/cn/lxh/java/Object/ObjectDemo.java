package cn.lxh.java.Object;

/**
 * object接收数组对象
 * Created by starlin
 * on 2015/10/07 21:16.
 */
public class ObjectDemo {
    public static void main(String[] args) {
        Object obj = new int[]{1,2,3,4,5};
        if(obj instanceof int[]){
            int[] temp = (int[]) obj;
            for(int i = 0;i<temp.length;i++){
                System.out.println(temp[i]);
            }
        }

    }
}
