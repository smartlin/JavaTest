package cn.lxh.java.Framework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map���ϣ��ü��ϴ洢��ֵ�ԣ�����Ҫ��֤��ֵ��Ψһ��
 * Map������ӣ�put(K key,V value)  putAll(Map<? extends K,? extends V> m)
 * put���Ԫ�أ����������ͬ�ļ�����ô����ӵļ�ֵ�Ḳ��ԭ�еļ�ֵ����put�����᷵�ر����ǵ�ֵ
 * Map����ɾ����clear()  remove(Object key)
 * Map�����жϣ�containsValue(Object value)  containsKey(Object key) isEmpty()
 * Map���ϻ�ȡ��get(Object key)  values()  size()  entrySet()  keySet()
 * Map����ȡ��ԭ����Map����ת��ΪSet���ϣ���ͨ��������ȡ��Iterator
 * Map�е�HashMap�� Hashtable��TreeMap,
 *          |---Hashtable���ײ��ǹ�ϣ�����ݽṹ�����������null��nullֵ���ý�����߳�ͬ����Ч�ʵ�
 *          |---HashMap���ײ��ǹ�ϣ�����ݽṹ���������null��nullֵ���ý�����߳�ͬ����Ч�ʸ�
 *          |---TreeMap���ײ��Ƕ��������ݽṹ���̲߳�ͬ������������map�����еļ���������
 * Created by starlin
 * on 2015/10/29 22:23.
 */
public class MapDemo1 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("zhangsan","20");
        map.put("zhangsan1","21");
        map.put("zhangsan2","22");
        map.put("zhangsan3","23");
        //����KeySetȡ�����м�ֵ
        Set<String> set = map.keySet();//keySet()
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key);
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
