package cn.lxh.java.lombok;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by starlin
 * on 2022/7/8 15:19.
 * 场景：生成无参和有参构造的方式
 * 1。Lombok同时使?@Data和@Builder的时候，如果要?成?参构造，需要在代码???动引?注解@Tolerate，
 * 让Lombok在?成类的时候，对指定的构造函数不感知
 *
 * 2。直接使用无参构造器+有参构造器的方式，
 * @RequiredArgsConstructor 来构建有参
 * @NoArgsConstructor 来构建无参构造器
 */
@Data
@RequiredArgsConstructor
//@NoArgsConstructor
public class LombokTest {
    /**
     * id
     */
    private String id;

    /**
     * name
     */
    private String name;

}
