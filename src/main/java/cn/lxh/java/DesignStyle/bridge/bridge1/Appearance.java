package cn.lxh.java.DesignStyle.bridge.bridge1;

/**
 * Created by starlin
 * on 2016/09/10 16:39.
 */
//外貌接口
public interface Appearance {
    public void show();
}

//屌丝外形
class Loser implements Appearance{

    public void show() {
        System.out.println("展示屌丝形象");
    }

}
//高富帅外形
class TRH implements Appearance{

    public void show() {
        System.out.println("展示高富帅形象");
    }

}