package cn.lxh.java.Framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Map集合
 * Collection设置数据的目的主要是为了输出，而Map设置数据主要目的是为了查找
 * 整个过程中都可以使用null操作
 * author:1762
 * Date:2015/09/12
 * Time:20:16
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> m = new HashMap<Integer, String>();
        m.put(1,"张三");
        m.put(1,"李四");
        m.put(2,"王五");
        m.put(null,"张三");
        m.put(3,"赵六");//put设置数据
        System.out.println(m.get(1));//key 重复时，前面的会被后面的覆盖
        System.out.println(m.get(null));
        System.out.println(m.get(200));//get方法取数据 没有找到值返回null
    }
}
