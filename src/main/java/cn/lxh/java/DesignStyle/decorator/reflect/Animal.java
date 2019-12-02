package cn.lxh.java.DesignStyle.decorator.reflect;

/**
 * Created by starlin
 * on 2019/9/21 16:07.
 */
public interface Animal {
    public void duStuff();
}

class Rat implements Animal {

    @Override
    public void duStuff() {
        System.out.println("Jerry will play with Tom;");
    }
}