package cn.lxh.java.Framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Map����
 * Collection�������ݵ�Ŀ����Ҫ��Ϊ���������Map����������ҪĿ����Ϊ�˲���
 * ���������ж�����ʹ��null����
 * author:1762
 * Date:2015/09/12
 * Time:20:16
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> m = new HashMap<Integer, String>();
        m.put(1,"����");
        m.put(1,"����");
        m.put(2,"����");
        m.put(null,"����");
        m.put(3,"����");//put��������
        System.out.println(m.get(1));//key �ظ�ʱ��ǰ��Ļᱻ����ĸ���
        System.out.println(m.get(null));
        System.out.println(m.get(200));//get����ȡ���� û���ҵ�ֵ����null
    }
}
