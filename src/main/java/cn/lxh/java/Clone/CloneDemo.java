package cn.lxh.java.Clone;

/**
 * Created by starlin
 * on 2018/9/20 15:02.
 * ʵ��Cloneable�ӿ�����¡����ǳ��¡
 */
public class CloneDemo implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneDemo cloneDemo = new CloneDemo();
        cloneDemo.setName("aa");
        System.out.println("cloneDemo---->" + cloneDemo.getName());
        CloneDemo cloneDemo1 = cloneDemo;
        cloneDemo1.setName("bb");
        System.out.println("cloneDemo---->" + cloneDemo.getName());
        System.out.println("cloneDemo1---->" + cloneDemo1.getName());

        System.out.println("/******************��¡ʹ��********************/");
        CloneDemo clone = new CloneDemo();
        clone.setName("clone");
        CloneDemo clone1 = (CloneDemo) clone.clone();

        System.out.println("clone �� clone1 �Ƿ����--->" + (clone == clone1));
        System.out.println("clone.equals(clone1)--->" + clone.equals(clone1));

        clone1.setName("clonebb");
        System.out.println("clone---->" + clone.getName());
        System.out.println("clone1---->" + clone1.getName());
    }
}
