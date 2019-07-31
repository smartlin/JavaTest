package cn.lxh.java.ManyJavaDemo;

/**
 * Created by starlin
 * on 2015/09/21 20:39.
 */
class Sex{
    private String title;
    private static final Sex MALE = new Sex("男");
    private static final Sex FEMALE = new Sex("女");

    private Sex(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
    public static Sex getInstance(String ch){
        switch (ch){//从JDK1.7开始switch开始接收String类型
            case "man":
                return MALE;
            case "woman":
                return FEMALE;
            default:
                return null;
        }
    }
}
public class ManyJava {
    public static void main(String[] args) {
        Sex s = Sex.getInstance("man");
        System.out.println(s);
    }
}
