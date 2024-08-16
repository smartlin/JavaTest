package cn.lxh.java.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by starlin
 * on 2024/8/16 14:36.
 */
public class PeekVsFroEachDemo {
    public static void main(String[] args) {
        testPeekAndforeach();
        testGetTargetUsers();
        testSimpleStopOptions();
    }

    public static void testPeekAndforeach() {
        List<String> sentences = Arrays.asList("hello world","Jia Gou Wu Dao");
        // ��ʾ��1����peek���������ղ���ִ��
        System.out.println("----before peek----");
        sentences.stream().peek(sentence -> System.out.println(sentence));
        System.out.println("----after peek----");
        // ��ʾ��2����foreach���������ջ�ִ��
        System.out.println("----before foreach----");
        sentences.stream().forEach(sentence -> System.out.println(sentence));
        System.out.println("----after foreach----");
        // ��ʾ��3��peek��������������ֹ������peek��ִ��
        System.out.println("----before peek and count----");
        sentences.stream().peek(sentence -> System.out.println(sentence)).count();
        System.out.println("----after peek and count----");
    }


    public static void testGetTargetUsers() {
        List<String> ids = Arrays.asList("205","10","308","49","627","193","111", "193");
        // ʹ��������
        List<OfferModel> results = ids.stream()
                .filter(s -> s.length() > 2)
                .distinct()
                .map(Integer::valueOf)
                .sorted(Comparator.comparingInt(o -> o))
                .limit(3)
                .map(id -> new OfferModel(id))
                .collect(Collectors.toList());
        System.out.println(results);
    }

    public static void testSimpleStopOptions() {
        List<String> ids = Arrays.asList("205", "10", "308", "49", "627", "193", "111", "193");
        // ͳ��stream������ʣ���Ԫ�ظ���
        System.out.println(ids.stream().filter(s -> s.length() > 2).count());
        // �ж��Ƿ���Ԫ��ֵ����205
        System.out.println(ids.stream().filter(s -> s.length() > 2).anyMatch("205"::equals));
        // findFirst����
        ids.stream().filter(s -> s.length() > 2)
                .findFirst()
                .ifPresent(s -> System.out.println("findFirst:" + s));
    }
}
