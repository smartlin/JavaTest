package cn.lxh.java.DesignStyle.SingletonDemo;

/**
 * 线程安全的单例模式
 * Created by starlin
 * on 2017/02/26 22:58.
 */
public class LazyInitHolderSingleton {
    private LazyInitHolderSingleton(){

    }

    private static class SingletonHolder{
        private static LazyInitHolderSingleton INSTANCE = new LazyInitHolderSingleton();
    }
    public static LazyInitHolderSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        LazyInitHolderSingleton lazyInitHolderSingleton1 = LazyInitHolderSingleton.getInstance();
        LazyInitHolderSingleton lazyInitHolderSingleton2 = LazyInitHolderSingleton.getInstance();
        System.out.println(lazyInitHolderSingleton1 == lazyInitHolderSingleton2);
    }
}
