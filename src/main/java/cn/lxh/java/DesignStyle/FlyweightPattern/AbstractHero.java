package cn.lxh.java.DesignStyle.FlyweightPattern;

/**
 * Created by starlin
 * on 2016/09/14 10:09.
 * 设计模式--享元模式
 */
public abstract class AbstractHero {

    protected final String name ; //英雄名字

    protected final String[] skills = new String[4];//每个英雄有4个技能

    protected long hp;//血量

    protected long mp;//魔法

    protected AbstractHero() {
        this.name = getName();
        initSkills();
        checkSkills();
    }

    private void checkSkills(){
        for(int i = 0;i<skills.length;i++){
            if(skills[i]==null){
                throw new NullPointerException();
            }
        }
    }

    //释放技能
    public void release(int index){
        if (index < 0) {
            index = 0;
        }else if (index > 3) {
            index = 3;
        }
        System.out.println(name + "释放" + skills[index]);
    }

    //物理攻击
    public void commonAttack(){
        System.out.println(name + "进行物理攻击");
    }

    public abstract String getName();

    public abstract void initSkills();

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getMp() {
        return mp;
    }

    public void setMp(long mp) {
        this.mp = mp;
    }
}
