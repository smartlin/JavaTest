package cn.lxh.java.Interface;

/**
 * 接口不能包含变量，定义的常量默认为static类型
 * 接口中定义的方法默认为public
 * 接口没有构造方法
 * 接口与接口之间存在多继承
 * Created by starlin
 * on 2015/09/20 15:16.
 */
interface Net{
  //  int i = 0;//定义的常量默认为static类型
    public void browser(String url);
}
class RealNet implements  Net{
    @Override
    public void browser(String url) {
        System.out.println("浏览的站点：" + url);
    }
}
class ProxyNet implements  Net{
    private Net net;
    public ProxyNet(RealNet net){
        this.net = net;
    }
    public boolean check(String url){
        if(url.contains("white")){
            System.out.println("访问非法网址");
            return false;
        }
        return true;
    }
    @Override
    public void browser(String url) {
        if(this.check(url)){
            this.net.browser(url);
        }
    }


}
public class Proxy {
    public static void main(String[] args) {
        Net net = new ProxyNet(new RealNet());
        net.browser("www.weibo.com");
        net.browser("whitehouse.com");
    }
}
