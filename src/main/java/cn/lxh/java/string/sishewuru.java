package cn.lxh.java.string;

import java.math.BigDecimal;

/**
 * 四舍五入操作
 * author:1762
 * Date:2015/09/06
 * Time:21:30
 */
class MyMath{
    public static double round(double num,int sacle){
        BigDecimal bd = new BigDecimal(num);
        BigDecimal resutl = bd.divide(new BigDecimal(1),sacle,BigDecimal.ROUND_HALF_UP);
        return resutl.doubleValue();
    }
}

public class sishewuru {
    public static void main(String[] args) {
        System.out.println(MyMath.round(7809.651298,2));
        System.out.println(MyMath.round(7809.651298,1));
        System.out.println(MyMath.round(-13.5,0));
    }
}
