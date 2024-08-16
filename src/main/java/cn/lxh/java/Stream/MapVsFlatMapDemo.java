package cn.lxh.java.Stream;

import cn.lxh.java.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by starlin
 * on 2024/8/16 14:26.
 */
public class MapVsFlatMapDemo {
    public static void main(String[] args) {
        mapDemo();
        flatMapDemo();
    }

    public static void mapDemo() {
        List<String> ids = Arrays.asList("205", "105", "308", "469", "627", "193", "111");
        // ʹ��������
        List<Student> results = ids.stream()
                .map(id -> {
                    Student model = new Student();
                    model.setId(id);;
                    return model;
                })
                .collect(Collectors.toList());
        System.out.println(results);
    }

    //����һ�������б���Ҫ��������ÿ�����ʶ���ȡ�����õ�һ�����е����б�
    public static void flatMapDemo() {
        List<String> sentences = Arrays.asList("hello world","Hello Price Info The First Version");
        // ʹ��������
        List<String> results2 = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());
        System.out.println(results2);
    }
}
