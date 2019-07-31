package cn.lxh.java.YunSuan;

/**
 * Created by starlin
 * on 2015/10/20 23:04.
 */
public class forTest {
    public static void main(String[] args) {
        for(int i = 0 ;i<5;i++){//外层控制行数
            for(int j = i;j< 5;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("------------------------------------");

        for(int i = 0 ;i<5;i++){//外层控制行数
            for(int j = 0;j<= i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("=================================");
        for(int i = 1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("=================================");
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
