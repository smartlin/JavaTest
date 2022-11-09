package cn.lxh.java.DesignStyle.FlyweightPattern;

public class Main {

    public static void main(String[] args) {
        //假设有四个solo局，则使用了享元模式的情况下，其实恶魔巫师和影魔的实例各自只有一个
        HeroManager heroManager = HeroManager.getInstance();
        Role role1 = new Role(heroManager.getHero("恶魔巫师"));
        Role role2 = new Role(heroManager.getHero("影魔"));
        
        Role role3 = new Role(heroManager.getHero("恶魔巫师"));
        Role role4 = new Role(heroManager.getHero("影魔"));
        
        Role role5 = new Role(heroManager.getHero("恶魔巫师"));
        Role role6 = new Role(heroManager.getHero("影魔"));
        
        Role role7 = new Role(heroManager.getHero("恶魔巫师"));
        Role role8 = new Role(heroManager.getHero("影魔"));
        
        /* 以下为释放技能，物理攻击等的打架过程  */
    }
    
}