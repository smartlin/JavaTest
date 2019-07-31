package cn.lxh.java.DesignStyle.memory;

/**
 * Created by starlin
 * on 2016/09/13 14:49.
 * 设计模式--备忘录模式
 */
public class Client {
    public static void main(String[] args) {
        Soul soul = new Soul();
        Person personA = new Person("看守所人员A");
        Person personB = new Person("看守所人员B");
        //看守所人员A的记忆
        personA.addStory("小时候偷换男女厕所的牌子");
        personA.addStory("用裤衩上的猴皮筋做成弹弓打别人家玻璃，结果被弹了小JJ");

        //看守所人员B的记忆
        personB.addStory("小时候比谁尿的更高更远，我得了第一，只是不小心方向变成了直上直下，尿到了自己脸上");
        personB.addStory("有一次正上课，不小心放了个屁，结果带出了点杂物，满教室都是臭味熏天");

        System.out.println(personA);
        System.out.println(personB);
        //灵魂（管理者）抽离两个人之前的记忆
        soul.pullAwayMemory(personA);
        soul.pullAwayMemory(personB);
        //两个人看到了小左的技能和面貌
        personA.addStory("有一个人竟然可以飞行，记忆中还记得他的样貌");
        personB.addStory("有一个人竟然可以飞行，记忆中还记得他的样貌");

        System.out.println(personA);
        System.out.println(personB);
        //强行恢复记忆
        soul.forceFixMemory(personA);
        soul.forceFixMemory(personB);

        System.out.println(personA);
        System.out.println(personB);
    }

}
