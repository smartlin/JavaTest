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
        // 使用流操作
        List<Student> results = ids.stream()
                .map(id -> {
                    Student model = new Student();
                    model.setId(id);;
                    return model;
                })
                .collect(Collectors.toList());
        System.out.println(results);
    }

    //现有一个句子列表，需要将句子中每个单词都提取出来得到一个所有单词列表
    public static void flatMapDemo() {
        List<String> sentences = Arrays.asList("hello world","Hello Price Info The First Version");
        // 使用流操作
        List<String> results2 = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());
        System.out.println(results2);
    }
}
