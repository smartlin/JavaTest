package cn.lxh.java.string;

/**
 * StringBuffer 操作
 * Created by 1762 on 2015/09/05.
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n").append("demo").append("world");
        System.out.println(sb);

        StringBuffer sb1 = new StringBuffer("demo world");
        sb1.insert(0, "你好");//insert 操作
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer("demo world");
        sb2.delete(3, 5);//delete 操作
        System.out.println(sb2);

        StringBuffer sb3 = new StringBuffer("demo world");
        sb3.reverse();//reverse 操作
        System.out.println(sb3);

        int[] str = {1,4,5,9};
        System.out.println(arrayToString(str));
    }
    //将数组变成字符串
    public static String arrayToString(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(i!=arr.length - 1){
                sb.append(arr[i] + "");
            }else{
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
