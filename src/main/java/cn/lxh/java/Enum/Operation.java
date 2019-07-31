package cn.lxh.java.Enum;

/**
 * Created by starlin
 * on 2016/10/24 16:09.
 */
public enum Operation {
    PLUS {
        double apply(double x ,double y){
            return x + y;
        }
    },
    MINUS {
        double apply(double x ,double y){
            return  x - y ;
        }
    },
    TIMES {
        double apply(double x ,double y){
            return x * y;
        }
    },
    DIVIDE {
        double apply(double x,double y){
            return x / y;
        }
    };
    abstract double apply(double x , double y);

    public static void main(String[] args) {

    }
}
