package cn.lxh.java.SimpleJavaClass;

/**
 * Created by starlin
 * on 2015/09/21 11:29.
 */
class Item{
    private int iid;
    private String name;
    private String note;
    private SubItem subItems[];
    private Production productions[];

    public Production[] getProductions() {
        return productions;
    }

    public void setProductions(Production[] productions) {
        this.productions = productions;
    }

    public SubItem[] getSubItems() {
        return subItems;

    }

    public void setSubItems(SubItem[] subItems) {
        this.subItems = subItems;
    }

    public Item(int iid, String name, String note) {
        this.iid = iid;
        this.name = name;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Item{" +
                "iid=" + iid +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
class SubItem{
    private int sid;
    private String name;
    private String note;
    private Item item;
    private Production productions[];

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Production[] getProductions() {
        return productions;
    }

    public void setProductions(Production[] productions) {
        this.productions = productions;
    }

    public SubItem(int sid, String name, String note) {
        this.sid = sid;
        this.name = name;
        this.note = note;
    }

    @Override
    public String toString() {
        return "SubItem{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
class Production{
    private int gid;
    private String name;
    private Double price;
    private SubItem subItems;
    private Item item;

    public SubItem getSubItems() {
        return subItems;
    }

    public void setSubItems(SubItem subItems) {
        this.subItems = subItems;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Production(int gid, String name, Double price) {
        this.gid = gid;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Production{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
public class ProductionSimpleJavaDemo {
    public static void main(String[] args) {
        //设置数据
        Item item = new Item(1,"食物","绿色食物");
        SubItem subItem1 = new SubItem(2,"水果","绿色水果");
        SubItem subItem2 = new SubItem(3,"蔬菜","绿色蔬菜");
        SubItem subItem3 = new SubItem(4,"鱼类","深海鱼类");
        Production production1 = new Production(21,"无籽西瓜",20.0);
        Production production2 = new Production(22,"有籽西瓜",10.0);
        Production production3 = new Production(31,"空心菜",5.0);
        Production production4 = new Production(32,"紫菜",2.0);
        Production production5 = new Production(41,"鲫鱼",10.0);
        Production production6 = new Production(42,"鲤鱼",30.0);
        //设置关系
        subItem1.setItem(item);//一个子类对应一个父类
        subItem2.setItem(item);//一个子类对应一个父类
        subItem3.setItem(item);//一个子类对应一个父类
        item.setSubItems(new SubItem[]{subItem1, subItem2, subItem3});//一个父类有多个子类

        subItem1.setProductions(new Production[]{production1, production2});//水果子类对应两个水果商品
        subItem2.setProductions(new Production[]{production3, production4});//素菜子类对应两个蔬菜商品
        subItem3.setProductions(new Production[]{production5, production6});//鱼类子类对应两个鱼类商品
        item.setProductions(new Production[]{production1, production2, production3, production4, production5, production6});
        production1.setItem(item);//一个商品有一个父类
        production2.setItem(item);//一个商品有一个父类
        production3.setItem(item);//一个商品有一个父类
        production4.setItem(item);//一个商品有一个父类
        production5.setItem(item);//一个商品有一个父类
        production6.setItem(item);//一个商品有一个父类
        production1.setSubItems(subItem1);//一个商品有一个子类
        production2.setSubItems(subItem1);//一个商品有一个子类
        production3.setSubItems(subItem2);//一个商品有一个子类
        production4.setSubItems(subItem2);//一个商品有一个子类
        production5.setSubItems(subItem3);//一个商品有一个子类
        production6.setSubItems(subItem3);//一个商品有一个子类

        System.out.println(item.toString());
        for(int x = 0;x<item.getProductions().length;x++){
            System.out.println("\t|- " + item.getProductions()[x].toString() );//一个类型找到全部商品
            System.out.println("\t\t|- " + item.getProductions()[x].getSubItems().toString());//商品下的子类型
        }
        System.out.println("================================================");
        for(int i = 0 ; i < item.getSubItems().length;i++){
            System.out.println(item.getSubItems()[i].toString());//一个父类下的所有子类
            for(int j= 0;j<item.getSubItems()[i].getProductions().length;j++){
                System.out.println("\t" + item.getSubItems()[i].getProductions()[j].toString());//子类下所有的商品
            }

        }
        System.out.println("*********************************************");
        for(int i = 0; i<subItem1.getProductions().length;i++){
            System.out.println(subItem1.getProductions()[i].toString() );//取得一个子类下的所有商品信息
        }
    }



}
