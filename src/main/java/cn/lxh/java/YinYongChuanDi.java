package cn.lxh.java;

/**
 * Created by starlin
 * on 2015/09/18 11:46.
 */
class Member{
    private int id;
    private String name;
    private Car car;
    private Member child;

    public Member getChild() {
        return child;
    }

    public void setChild(Member child) {
        this.child = child;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public Member(int id,String name){
        this.id = id;
        this.name = name;
    }
}

/**
 *
 */
class Car{
    private String cname;
    private Member member;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cname='" + cname + '\'' +
                '}';
    }

    public Car(String cname){
        this.cname = cname;
    }
}
public class YinYongChuanDi {
    public static void main(String[] args) {
        Member m = new Member(1,"张三");
        Member mchild = new Member(2,"李四");
        Car c = new Car("宝马");
        Car cc = new Car("法拉利");
        m.setCar(c);
        c.setMember(m);
        System.out.println(m.getCar().toString());
        System.out.println(c.getMember().toString());
        mchild.setCar(cc);//一个孩子有一辆车
        cc.setMember(mchild);//一辆车属于一个孩子
        m.setChild(mchild);//一个人有一个孩子
        //通过人找到他孩子信息
        System.out.println(m.getChild().toString());
        //通过人找到他孩子车的信息
        System.out.println(m.getChild().getCar().toString());
    }
}
