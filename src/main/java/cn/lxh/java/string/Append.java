package cn.lxh.java.string;

/**
 * Created by starlin
 * on 2016/06/01 13:54.
 */
public class Append {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<3;i++){
            sb.append(i).append(",").toString();

        }
        //去掉最后一个逗号
        if(sb.length()>0){
            //方法一：substring
            System.out.println(sb.substring(0,sb.length()-1));
            System.out.println("0,1".indexOf("1"));
            //方法二 ：replace
            System.out.println(sb.replace(sb.length() - 1, sb.length(), ""));
            //方法三： deleteCharAt 貌似不行
            System.out.println(sb.deleteCharAt(sb.length()-1));
        }


    }
}
