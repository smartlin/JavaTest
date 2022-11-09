package cn.lxh.java.FanXing;

/**
 * 泛型接口
 * Created by starlin
 * on 2015/09/20 16:56.
 */
interface IMessage<T> {
    public void print(T t);
}
class MessageImpl implements IMessage<String>{

    @Override
    public void print(String t) {
        System.out.println(t);
    }
}
public class IFanXing{
    public static void main(String[] args) {
        IMessage<String> msg = new MessageImpl();
        msg.print("Hello world");
    }
}