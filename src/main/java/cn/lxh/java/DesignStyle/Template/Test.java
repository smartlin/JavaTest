package cn.lxh.java.DesignStyle.Template;

/**
 * Created by starlin
 * on 2018/3/18 22:14.
 */
public class Test {
    public static void main(String[] args) {
        AbstractTemplate abstractTemplate = new ConcreteTemplate();
        //����ģ�巽��
        abstractTemplate.templateMethod();
    }
}
