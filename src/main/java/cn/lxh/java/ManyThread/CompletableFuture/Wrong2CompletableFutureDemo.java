package cn.lxh.java.ManyThread.CompletableFuture;

/**
 * Created by starlin
 * on 2024/8/13 15:04.
 * Stream流结合使用
 * 传入多个商品，查询不同商品对应的价格与优惠信息，并选出实付价格最低的商品信息
 * 因为Stream的操作具有延迟执行的特点，且只有遇到终止操作（比如collect方法）的时候才会真正的执行。
 * 所以遇到这种需要并行处理且需要合并多个并行处理流程的情况下，需要将并行流程与合并逻辑放到两个Stream中，
 * 这样分别触发完成各自的处理逻辑，就可以了
 */
public class Wrong2CompletableFutureDemo {
    public static void main(String[] args) {

    }

//    下面的代码效果实际不是并发的，而是串行地对每个商品进行价格计算并比价，类似于下面的代码。
//    public PriceResult comparePriceInOnePlat(List<String> products) {
//        return products.stream()
//                .map(product ->
//                        CompletableFuture.supplyAsync(() -> HttpRequestMock.getPrice(product))
//                                .thenCombine(
//                                        CompletableFuture.supplyAsync(() -> HttpRequestMock.getDiscounts(product)),
//                                        this::computeRealPrice))
//                .map(CompletableFuture::join)
//                .sorted(Comparator.comparingInt(PriceResult::getRealPrice))
//                .findFirst()
//                .get();
//    }

     // 下面代码效果与上面的相同，都是串行的
//    public PriceResult comparePriceInOnePlat1(List<String> products) {
//        return products.stream()
//                .map(product -> CompletableFuture.supplyAsync(() -> HttpRequestMock.getPrice(product)).thenCombine(CompletableFuture.supplyAsync(() -> HttpRequestMock.getDiscounts(product)), this::computeRealPrice).join())
//                .sorted(Comparator.comparingInt(PriceResult::getRealPrice))
//                .findFirst()
//                .get();
//    }

    //正确的做法
//    public PriceResult comparePriceInOnePlat2(List<String> products) {
//        // 先创建多个并行的任务
//        List<CompletableFuture<PriceResult>> completableFutures = products.stream()
//                .map(product -> CompletableFuture.supplyAsync(() -> HttpRequestMock.getPrice(product)).thenCombine(CompletableFuture.supplyAsync(() -> HttpRequestMock.getDiscounts(product)), this::computeRealPrice))
//                .collect(Collectors.toList());
//        // 在独立的流中，等待所有任务处理结束，做最终结果处理
//        return completableFutures.stream()
//                .map(CompletableFuture::join)
//                .sorted(Comparator.comparingInt(PriceResult::getRealPrice))
//                .findFirst()
//                .get();
//    }
}
