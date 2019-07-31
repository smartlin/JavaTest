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
        Member m = new Member(1,"����");
        Member mchild = new Member(2,"����");
        Car c = new Car("����");
        Car cc = new Car("������");
        m.setCar(c);
        c.setMember(m);
        System.out.println(m.getCar().toString());
        System.out.println(c.getMember().toString());
        mchild.setCar(cc);//һ��������һ����
        cc.setMember(mchild);//һ��������һ������
        m.setChild(mchild);//һ������һ������
        //ͨ�����ҵ���������Ϣ
        System.out.println(m.getChild().toString());
        //ͨ�����ҵ������ӳ�����Ϣ
        System.out.println(m.getChild().getCar().toString());
    }
}
