package cn.lxh.java.lombok;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by starlin
 * on 2020/9/21 16:48.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Company extends Person {
    /**
     * ¹«Ë¾
     */
    private String company;

    public Company(int id, String name,String company) {
        super(id, name);
        this.company = company;
    }

    public static void main(String[] args) {
        Company c1 = new Company(1, "zhangs", "c");
        Company c2 = new Company(2, "lisi", "c");
        System.out.println(c1.equals(c2));
    }
}
