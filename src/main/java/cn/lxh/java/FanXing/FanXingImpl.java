package cn.lxh.java.FanXing;

/**
 * �ӿ��϶��巺��
 * Created by starlin
 * on 2015/10/29 20:20.
 */
interface Inter<T>{
    public void show(T t);
}
//class Interimpl implements Inter<String>{
//
//    @Override
//    public void show(String s) {
//        System.out.println("show:" + s);
//    }
//}
class Interimpl<T> implements Inter<T>{

    @Override
    public void show(T t) {
        System.out.println("show:" + t);
    }
}
public class FanXingImpl {
    public static void main(String[] args) {
//        Interimpl i = new Interimpl();
//        i.show("demo world");
        Interimpl<Integer> i = new Interimpl<Integer>();
        i.show(4);
    }
}
