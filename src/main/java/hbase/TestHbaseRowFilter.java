package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;

import java.io.IOException;

public class TestHbaseRowFilter {
        String tableName = "PartyLog";
        Configuration config = HBaseConfiguration.create();
        
        public void testRowFilter() throws IOException {
                HTable table = new HTable(config, tableName);
                Scan scan = new Scan();
               /* System.out.println("小于等于row010的行");
                Filter filter1 = new RowFilter(CompareFilter.CompareOp.LESS_OR_EQUAL,
                                new BinaryComparator("row010".getBytes()));
                scan.setFilter(filter1);
                ResultScanner scanner1 = table.getScanner(scan);
                for (Result res : scanner1) {
                        System.out.println(res);
                }
                scanner1.close();*/
               /* System.out.println("正则获取结尾为5的行");
                Filter filter2 = new RowFilter(CompareFilter.CompareOp.EQUAL,
                                new RegexStringComparator(".*5[        DISCUZ_CODE_0        ]quot;));
                scan.setFilter(filter2);
                ResultScanner scanner2 = table.getScanner(scan);
                for (Result res : scanner2) {
                        System.out.println(res);
                }
                scanner2.close();*/
                System.out.println("包含有10000的行");
                Filter filter3 = new RowFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator("10000"));
                scan.setFilter(filter3);
                ResultScanner scanner3 = table.getScanner(scan);
                for (Result res : scanner3) {
                        System.out.println(res);
                }
                scanner3.close();
               /* System.out.println("开头是row01的");
                Filter filter4 = new RowFilter(CompareFilter.CompareOp.EQUAL,
                                new BinaryPrefixComparator("row01".getBytes()));
                scan.setFilter(filter4);
                ResultScanner scanner4 = table.getScanner(scan);
                for (Result res : scanner4) {
                        System.out.println(res);
                }
                scanner3.close();*/
        }
        
        public void init() {
                // 创建表和初始化数据
                try {
                        HBaseAdmin admin = new HBaseAdmin(config);
                        if (!admin.tableExists(tableName)) {
                                HTableDescriptor htd = new HTableDescriptor(tableName);
                                HColumnDescriptor hcd1 = new HColumnDescriptor("data");
                                htd.addFamily(hcd1);
                                HColumnDescriptor hcd2 = new HColumnDescriptor("url");
                                htd.addFamily(hcd2);
                                admin.createTable(htd);
                        }
                        HTable table = new HTable(config, tableName);
                        table.setAutoFlush(false);
                        int count = 50;
                        for (int i = 1; i <= count; ++i) {
                                Put p = new Put(String.format("rowd", i).getBytes());
                                p.add("data".getBytes(), String.format("cold", i % 10)
                                                .getBytes(), String.format("datad", i).getBytes());
                                p.add("url".getBytes(), String.format("cold", i % 10)
                                                .getBytes(), String.format("urld", i).getBytes());
                                table.put(p);
                        }
                        table.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        
        public static void main(String[] args) throws IOException {
                TestHbaseRowFilter test = new TestHbaseRowFilter();
                //test.init();
                test.testRowFilter();
        }
}