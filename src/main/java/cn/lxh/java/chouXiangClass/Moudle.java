package cn.lxh.java.chouXiangClass;

/**
 * Created by starlin
 * on 2015/10/22 23:24.
 */
abstract class GetTime{
    public final void getTime(){
        long statt = System.currentTimeMillis();
        this.code();
        long end = System.currentTimeMillis();
        System.out.println("Time:" + (end- statt));
    }
    public abstract void code();
}

class Get extends GetTime{

    @Override
    public void code() {
        for(int i=0;i<4000;i++){
            System.out.println(i);
        }
    }
}
public class Moudle {
    public static void main(String[] args) {
        Get g = new Get();
        g.getTime();
    }
}
