package cn.lxh.java.BloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Created by starlin
 * on 2019/3/17 21:20.
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.01);

        for(int i=0;i<=10000000;i++){
            bloomFilter.put(i);
        }

        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(2));
        System.out.println(bloomFilter.mightContain(10000000));

        long end = System.currentTimeMillis();

        System.out.println("Ö´ÐÐÊ±¼ä£º" + (end - start));
    }

}
