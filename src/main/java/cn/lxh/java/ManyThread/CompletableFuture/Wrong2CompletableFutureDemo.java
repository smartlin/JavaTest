package cn.lxh.java.ManyThread.CompletableFuture;

/**
 * Created by starlin
 * on 2024/8/13 15:04.
 * Stream�����ʹ��
 * ��������Ʒ����ѯ��ͬ��Ʒ��Ӧ�ļ۸����Ż���Ϣ����ѡ��ʵ���۸���͵���Ʒ��Ϣ
 * ��ΪStream�Ĳ��������ӳ�ִ�е��ص㣬��ֻ��������ֹ����������collect��������ʱ��Ż�������ִ�С�
 * ��������������Ҫ���д�������Ҫ�ϲ�������д������̵�����£���Ҫ������������ϲ��߼��ŵ�����Stream�У�
 * �����ֱ𴥷���ɸ��ԵĴ����߼����Ϳ�����
 */
public class Wrong2CompletableFutureDemo {
    public static void main(String[] args) {

    }

//    ����Ĵ���Ч��ʵ�ʲ��ǲ����ģ����Ǵ��еض�ÿ����Ʒ���м۸���㲢�ȼۣ�����������Ĵ��롣
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

     // �������Ч�����������ͬ�����Ǵ��е�
//    public PriceResult comparePriceInOnePlat1(List<String> products) {
//        return products.stream()
//                .map(product -> CompletableFuture.supplyAsync(() -> HttpRequestMock.getPrice(product)).thenCombine(CompletableFuture.supplyAsync(() -> HttpRequestMock.getDiscounts(product)), this::computeRealPrice).join())
//                .sorted(Comparator.comparingInt(PriceResult::getRealPrice))
//                .findFirst()
//                .get();
//    }

    //��ȷ������
//    public PriceResult comparePriceInOnePlat2(List<String> products) {
//        // �ȴ���������е�����
//        List<CompletableFuture<PriceResult>> completableFutures = products.stream()
//                .map(product -> CompletableFuture.supplyAsync(() -> HttpRequestMock.getPrice(product)).thenCombine(CompletableFuture.supplyAsync(() -> HttpRequestMock.getDiscounts(product)), this::computeRealPrice))
//                .collect(Collectors.toList());
//        // �ڶ��������У��ȴ���������������������ս������
//        return completableFutures.stream()
//                .map(CompletableFuture::join)
//                .sorted(Comparator.comparingInt(PriceResult::getRealPrice))
//                .findFirst()
//                .get();
//    }
}
