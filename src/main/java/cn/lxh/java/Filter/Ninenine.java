package cn.lxh.java.Filter;

/**
 * Created by starlin
 * on 2015/09/22 11:14.
 */
public class Ninenine {
    public static void main(String[] args) {
        for(int x= 1;x<=9;x++){
            for(int y=1;y<=x;y++){
                System.out.print(x + "*" + y + "=" + x * y);
            }
        }
    }
}
