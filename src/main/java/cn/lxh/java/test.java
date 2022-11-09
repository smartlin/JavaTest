package cn.lxh.java;

/**
 * Created by starlin
 * on 2016/02/02 14:05.
 */
public class test {
    private String valve1, valve2, valve3, valve4;
    private WaterSource source;
    int i;
    float f;
    void print() {
        System.out.println("valve1 = " + valve1);
        System.out.println("valve2 = " + valve2);
        System.out.println("valve3 = " + valve3);
        System.out.println("valve4 = " + valve4);
        System.out.println("i = " + i);
        System.out.println("f = " + f);
        System.out.println("source = " + source);
    }
    public static void main(String[] args) {
        test t = new test();
        t.print();
    }
}

class WaterSource {
    private String s;
    public WaterSource() {
        System.out.println("WaterSource()");
        s = new String("Constructed");
    }
    public String toString() { return s; }
}