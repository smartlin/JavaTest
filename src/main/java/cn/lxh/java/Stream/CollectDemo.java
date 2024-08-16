package cn.lxh.java.Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by starlin
 * on 2024/8/16 15:30.
 */
public class CollectDemo {
    public static void main(String[] args) {
        collectTest();
        testCollectJoinStrings();
        testNumberCalculate();
    }
    public static void collectTest(){
        List<NormalOfferModel> normalOfferModelList = Arrays.asList(new NormalOfferModel("11"),
                new NormalOfferModel("22"),
                new NormalOfferModel("33"));

        // collect成list
        List<NormalOfferModel> collectList = normalOfferModelList
                .stream()
                .filter(offer -> offer.getCate1LevelId().equals("11"))
                .collect(Collectors.toList());
        System.out.println("collectList:" + collectList);

        // collect成Set
        Set<NormalOfferModel> collectSet = normalOfferModelList
                .stream()
                .filter(offer -> offer.getCate1LevelId().equals("22"))
                .collect(Collectors.toSet());
        System.out.println("collectSet:" + collectSet);

        // collect成HashMap，key为id，value为Dept对象
        Map<String, NormalOfferModel> collectMap = normalOfferModelList
                .stream()
                .filter(offer -> offer.getCate1LevelId().equals("33"))
                .collect(Collectors.toMap(NormalOfferModel::getCate1LevelId, Function.identity(), (k1, k2) -> k2));
        System.out.println("collectMap:" + collectMap);
    }


    public static void testCollectJoinStrings() {
        List<String> ids = Arrays.asList("205", "10", "308", "49", "627", "193", "111", "193");
        String joinResult = ids.stream().collect(Collectors.joining(","));
        System.out.println("拼接后：" + joinResult);
    }


    public static void testNumberCalculate() {
        List<Integer> ids = Arrays.asList(10, 20, 30, 40, 50);
        // 计算平均值
        Double average = ids.stream().collect(Collectors.averagingInt(value -> value));
        System.out.println("平均值：" + average);
        // 数据统计信息
        IntSummaryStatistics summary = ids.stream().collect(Collectors.summarizingInt(value -> value));
        System.out.println("数据统计信息：" + summary);
    }
}
